package com.nj.controller;

import com.nj.bean.RoleBean;
import com.nj.service.RoleService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 08:27
 */
@RestController
@RequestMapping("role")
@Api(description = "角色管理")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping("getAll")
    @ApiOperation("查询所有的角色")
    public ResponseUtil getAll(){
        return service.findAll();
    }

    @GetMapping("editStatusById")
    @ApiOperation("修改角色状态")
    public ResponseUtil editStatusById(Integer roleid,Integer status){
        return service.modifyStatusById(roleid,status);
    }

    @GetMapping("getRidByUserid")
    @ApiOperation("通过用户id查看角色")
    public ResponseUtil getRidByUserid(Integer userid){
        return service.getRidByUserid(userid);
    }

    @GetMapping("editRoleByUserid")
    @ApiOperation("修改用户权限")
    public ResponseUtil editRoleByUserid(Integer userid, Integer[] rids){
        return service.modifyRoleByUserid(userid,rids);
    }

    @PostMapping("saveRoleName")
    @ApiOperation("添加角色名")
    public ResponseUtil saveRoleName(@RequestBody RoleBean roleBean){
        return service.addRole(roleBean);
    }
}
