package com.nj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 20:17
 */
@Controller
@RequestMapping("forward")
public class ForwardController {

    @GetMapping("toLogin")
    public String getLogin(){
        return "login";
    }

    @GetMapping("toMain")
    public String getMain(){
        return "main";
    }

    @GetMapping("toUser")
    public String getUser(){
        return "user/getUser";
    }

    @GetMapping("toEditPwd")
    public String toEditPwd(){
        return "user/edit_pwd";
    }

    @GetMapping("toEditHeadimg")
    public String toEditHeadimg(){
        return "user/edit_headimg";
    }

    @GetMapping("toGetDept")
    public String toGetDept(){
        return "user/getDept";
    }

    @GetMapping("toGetCompany")
    public String toGetCompany(){
        return "custom/getCompany";
    }

    @GetMapping("toGetCustomer")
    public String toGetCustomer(){
        return "custom/getCustomer";
    }

    @GetMapping("toGetRecoder")
    public String toGetRecoder(){
        return "custom/getRecoder";
    }

    @GetMapping("toGetRole")
    public String toGetRole(){
        return "role/getRole";
    }

    @GetMapping("toGetPermission")
    public String toGetPermission(){
        return "role/getPermission";
    }

    @GetMapping("toGetElement")
    public String toGetElement(){
        return "element_main";
    }

    @GetMapping("toGetUserCustomer")
    public String toGetUserCustomer(){
        return "all/user_customer";
    }
}
