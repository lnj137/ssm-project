package com.nj.controller;

import com.nj.bean.DepartmentBean;
import com.nj.bean.DeptQuery;
import com.nj.service.DeptService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-04 13:46
 */
@RestController
@RequestMapping("dept")
@Api(description = "部门")
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping
    @ApiOperation("根据id查询部门信息")
    public ResponseUtil getDept(Integer id){
        return service.findById(id);
    }

    @GetMapping("deptAll")
    @ApiOperation("查询所有部门")
    public ResponseUtil getAll(){
        return service.findAll();
    }

    @PostMapping("saveDept")
    @ApiOperation("添加部门")
    public ResponseUtil saveDept(@RequestBody DepartmentBean dept){
        return service.addDept(dept);
    }

    @GetMapping("getAllByPage")
    @ApiOperation("分页加模糊搜索获取部门")
    public ResponseUtil getAllByPage(DeptQuery deptQuery){
        return service.findAllByPage(deptQuery);
    }

    @PutMapping("editDeptById")
    @ApiOperation("通过id修改部门")
    public ResponseUtil editDeptById(@RequestBody DepartmentBean dept){
        return service.modifyDeptById(dept);
    }

    @GetMapping("editStatusById")
    @ApiOperation("通过id修改状态")
    public ResponseUtil editStatusById(Integer did,Integer status){
        return service.modifyStatusById(did,status);
    }

}

