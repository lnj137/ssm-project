package com.nj.service;

import com.nj.bean.UserQueryBean;
import com.nj.bean.UserinfoBean;
import com.nj.utils.ResponseUtil;
import io.swagger.models.auth.In;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 18:58
 */
public interface UserService {
    //分页查询所有
    ResponseUtil findAll(UserQueryBean qu);
    //通过账号密码查询，实现登录
    ResponseUtil findUserByUsernameAndPassword(String username, String password, String code, HttpSession session);
    //添加用户
    ResponseUtil addUser(UserinfoBean u);
    //修改用户状态
    ResponseUtil modifyStatus(Integer userid,Integer newStatus);
    //查询重复用户名
    ResponseUtil findRepeatUsername(String username);
    //通过id重置用户密码
    ResponseUtil modifyPwdById(Integer userid);
    //通过id修改用户信息
    ResponseUtil modifyUserById(UserinfoBean u);
    //修改密码
    ResponseUtil modifyPwd(Integer userid,String oldPwd,String newPwd);
    //修改头像,文件上传
    ResponseUtil modifyHeadimgById(Integer userid, MultipartFile file);
    //查询所有不分页
    ResponseUtil findAllUser();
    //通过用户登录的id，获取到用户对应的权限
    ResponseUtil findUserPermission(Integer userid);
    //用户的跟踪记录
    ResponseUtil findUserCusRecoder();


}
