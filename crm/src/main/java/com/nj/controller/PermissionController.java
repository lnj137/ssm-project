package com.nj.controller;

import com.nj.bean.PermissionBean;
import com.nj.service.PermissionService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 13:08
 */
@RestController
@RequestMapping("permission")
@Api(description = "权限管理")
public class PermissionController {
    @Resource
    private PermissionService service;

    @GetMapping("getAll")
    @ApiOperation("获取权限树")
    public ResponseUtil getAll(){
        return service.findAll();
    }

    @GetMapping("getPidByRid")
    @ApiOperation("获取角色对应的权限")
    public ResponseUtil getPidByRid(Integer roleid){
        return service.findPidByRid(roleid);
    }

    @GetMapping("editRolePs")
    @ApiOperation("获取角色对应的权限")
    public ResponseUtil editRolePs(Integer roleid,Integer[] pids){
        return service.modifyRolePs(roleid,pids);
    }

    @PostMapping("addPermission")
    @ApiOperation("添加权限")
    public ResponseUtil addPermission(@RequestBody PermissionBean permission){
        return service.addPermission(permission);
    }

    @DeleteMapping("cutPermissionByPid")
    @ApiOperation("删除子权限")
    public ResponseUtil cutPermissionByPid(Integer pid){
        return service.removePermissionByPid(pid);
    }

    @PutMapping("editPermissionByPid")
    @ApiOperation("修改权限")
    public ResponseUtil editPermissionByPid(@RequestBody PermissionBean permission){
        return service.editPermission(permission);
    }


}
