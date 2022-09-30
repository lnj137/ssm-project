package com.nj.controller;

import com.nj.bean.CompanyBean;
import com.nj.bean.CompanyQuery;
import com.nj.service.CompanyService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-06 21:21
 */
@RestController
@RequestMapping("company")
@Api(description = "用户公司管理")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @GetMapping("getAll")
    @ApiOperation("查询所有公司")
    public ResponseUtil getAll(){
        return service.findAll();
    }

    @GetMapping("getAllByPage")
    @ApiOperation("分页加模糊查询")
    public ResponseUtil getAllByPage(CompanyQuery companyQuery){
        return service.findAllByPage(companyQuery);
    }

    @PostMapping("saveCompany")
    @ApiOperation("添加公司")
    public ResponseUtil saveCompany(@RequestBody CompanyBean company){
        return service.addCompany(company);
    }

    @PutMapping("editCompany")
    @ApiOperation("修改公司信息")
    public ResponseUtil editCompany(@RequestBody CompanyBean company){
        return service.modifyCompanyById(company);
    }

    @GetMapping("editStatus")
    @ApiOperation("修改公司状态")
    public ResponseUtil editStatus(Integer companyid,Integer status){
        return service.modifyStatusById(companyid,status);
    }

}
