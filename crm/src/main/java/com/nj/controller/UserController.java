package com.nj.controller;

import com.nj.bean.UserQueryBean;
import com.nj.bean.UserinfoBean;
import com.nj.service.UserService;
import com.nj.utils.ResponseUtil;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 19:15
 */
@RestController
@RequestMapping("user")
@Api(description = "用户操作")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("getUserByPage")
    @ApiOperation("分页获取用户")
    public ResponseUtil getAllUser(UserQueryBean qu){
        ResponseUtil list = service.findAll(qu);
        return list;
    }

    @GetMapping("login")
    @ApiOperation("登录")
    public ResponseUtil getUserByNameAndPwd(String username, String password, String code, HttpSession session){
        ResponseUtil res = service.findUserByUsernameAndPassword(username, password, code, session);
        return res;
    }


    @PostMapping("insert")
    @ApiOperation("添加用户")
    public ResponseUtil saveUser(@RequestBody UserinfoBean u){
        ResponseUtil res = service.addUser(u);
        return res;
    }

    @GetMapping("editStatus")
    @ApiOperation("通过用户id修改用户状态")
    public ResponseUtil editStatus( Integer userid,Integer newStatus){
        return service.modifyStatus(userid, newStatus);
    }

    @GetMapping("getUsername")
    @ApiOperation("查询是否含有重复用户名")
    public ResponseUtil getRepeatUsername(String username){
        return service.findRepeatUsername(username);
    }

    @GetMapping("editPwd")
    @ApiOperation("通过id重置密码")
    public ResponseUtil editPwdByUserId(Integer userid){
        return service.modifyPwdById(userid);
    }

    @PutMapping("editUserById")
    @ApiOperation("通过id修改用户信息")
    public ResponseUtil editUserById(@RequestBody UserinfoBean u){
        return service.modifyUserById(u);
    }

    @GetMapping("editPwdById")
    @ApiOperation("修改密码")
    public ResponseUtil editPwd(Integer userid,String oldPwd,String newPwd){
        return service.modifyPwd(userid,oldPwd,newPwd);
    }

    @PostMapping("editHeadimgById")
    @ApiOperation("修改头像")
    public ResponseUtil editHeadimgById(Integer userid, MultipartFile file){
        return service.modifyHeadimgById(userid,file);
    }

    @GetMapping("getAll")
    @ApiOperation("获取所有用户不分页")
    public ResponseUtil getAll(){
        return service.findAllUser();
    }

    @GetMapping("getUserPermission")
    @ApiOperation("根据用户id获取用户权限")
    public ResponseUtil getUserPermission(Integer userid){
        return service.findUserPermission(userid);
    }

    @GetMapping("logout")
    @ApiOperation("让session失效")
    public ResponseUtil logout(HttpSession session){
        session.invalidate();//让session失效
        return new ResponseUtil();
    }

    @GetMapping("getUserCusRecoder")
    @ApiOperation("用户的跟踪统计")
    public ResponseUtil getUserCusRecoder(){
        return service.findUserCusRecoder();
    }

}
