package com.nj.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.nj.bean.PermissionBean;
import com.nj.bean.UserQueryBean;
import com.nj.bean.UserinfoBean;
import com.nj.dao.PermissionDao;
import com.nj.dao.UserDao;
import com.nj.service.UserService;
import com.nj.utils.Commons;
import com.nj.utils.Md5Util;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 19:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    /**
     * 分页查询所有
     * @param qu
     * @return
     */
    @Override
    public ResponseUtil findAll(UserQueryBean qu) {
        //开启分页
        PageHelper.startPage(qu.getPageNum(), qu.getPageSize());
        List<UserinfoBean> list = dao.selectAll(qu);

        PageInfo<UserinfoBean> page = new PageInfo<>(list);
        ResponseUtil res = new ResponseUtil(page.getList());
        res.setTotal(page.getTotal());
        return res;
    }

    @Override
    public ResponseUtil findUserByUsernameAndPassword(String username, String password, String code, HttpSession session) {
        String relCode = (String) session.getAttribute("code");//取出来真实的验证码
        ResponseUtil res = new ResponseUtil();
        if (StrUtil.equals(relCode,code)){//验证码通过
            //加密之后的密码
            UserinfoBean user = dao.selectByUsernameAndPassword(username, Md5Util.getMd5Password(password));
            if (null!=user){//登录成功
                if (user.getStatus()!=0){//用户被禁用
                    return new ResponseUtil(Commons.ERROR,"该账户已经被禁用");
                }else {
                    res.setResult(user);
                    session.setAttribute("user",user);
                }

            }else {
                res.setCode(Commons.ERROR);
                res.setMsg(Commons.ERROR_LOGIN_MSG);
            }
        }else {
            res.setCode(Commons.ERROR);
            res.setMsg("验证码输入有误");
        }
        return res;
    }

    @Override
    public ResponseUtil addUser(UserinfoBean u) {
        int i = dao.insertUser(u);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(400,"添加失败");
    }

    @Override
    public ResponseUtil modifyStatus(Integer userid, Integer newStatus) {
        int i = dao.updateStatusById(userid, newStatus);
        if (i>0){//修改成功
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil findRepeatUsername(String username) {
        List<UserinfoBean> list = dao.selectUserByUsername(username);
        if (null == list || list.size()==0){//用户不存在
            return new ResponseUtil();
        }else {
            return new ResponseUtil(Commons.ERROR,"用户名重复");
        }
    }

    @Override
    public ResponseUtil modifyPwdById(Integer userid) {
        int i = dao.updatePwdById(userid, Md5Util.getMd5Password("123456"));
        if (i>0){//修改成功
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyUserById(UserinfoBean u) {
        int i = dao.updateUserById(u);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyPwd(Integer userid, String oldPwd, String newPwd) {
        UserinfoBean user = dao.selectPwdById(userid);
        //相等
        if (StrUtil.equals(user.getPassword(),Md5Util.getMd5Password(oldPwd))) {
            int i = dao.updatePwdById(userid, Md5Util.getMd5Password(newPwd));
            if (i>0){
                return new ResponseUtil();
            }else {
                return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
            }
        }else {
            return new ResponseUtil(400,"原始密码输入有误，请检查");
        }

    }

    @Override
    public ResponseUtil modifyHeadimgById(Integer userid, MultipartFile file) {
        //获取文件的真实名称
        String orgName = file.getOriginalFilename();
        String sufferFileName = orgName.substring(orgName.lastIndexOf("."));
        //新的文件名
        String headimg = UUID.randomUUID() + sufferFileName;
        //设置文件上传的路径
        File file1 = new File("D:\\LNJ\\Projects\\crm_ssm\\upload\\");
        if (!file.isEmpty()){//不存在这个路径就创建
            file1.mkdirs();
        }
        try {
            //上传图片
            file.transferTo(new File(file1+"\\"+headimg));
            //修改文件名
            int i = dao.updateHeadimg(userid, headimg);
            if (i>0){
                //将文件名返回给前端
                return new ResponseUtil(headimg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil findAllUser() {
        UserQueryBean userQueryBean = null;
        List<UserinfoBean> list = dao.selectAll(userQueryBean);
        return new ResponseUtil(list);
    }

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public ResponseUtil findUserPermission(Integer userid) {
        UserinfoBean user = dao.selectAllByUserid(userid);
        if (user.getIsadmin() == 1){//是超级管理员
            List<PermissionBean> ps = permissionDao.selecrAllPermission();
            return new ResponseUtil(ps);
        }

        List<PermissionBean> list = dao.selectPermissionByUserid(userid);
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil findUserCusRecoder() {
        List<Map> maps = dao.selectUserCus();
        return new ResponseUtil(maps);
    }
}
