package com.nj.dao;

import com.nj.bean.PermissionBean;
import com.nj.bean.UserQueryBean;
import com.nj.bean.UserinfoBean;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 18:56
 */
public interface UserDao {
    //查询所有
    List<UserinfoBean> selectAll(UserQueryBean qu);

    //查询单个用户，负责进行登录
    UserinfoBean selectByUsernameAndPassword(String username,String password);

    //添加用户
    int insertUser(UserinfoBean u);

    //修改用户状态
    int updateStatusById(Integer id, Integer newStatus);

    //通过用户名查询用户表，判断是否存在相同用户
    List<UserinfoBean> selectUserByUsername(String username);

    //通过id修改密码
    int updatePwdById(Integer userid,String pwd);

    //通过id进行修改
    int updateUserById(UserinfoBean u);

    //通过id查询原始密码
    UserinfoBean selectPwdById(Integer userid);

    //将头像名称根据id存储到表中，后面查询通过唯一的文件名进行查询
    int updateHeadimg(Integer userid,String headimgName);

    //通过用户id查询用户的权限
    List<PermissionBean> selectPermissionByUserid(Integer userid);

    //通过id查询用户信息
    UserinfoBean selectAllByUserid(Integer userid);

    //用户的跟踪记录
    List<Map> selectUserCus();

}
