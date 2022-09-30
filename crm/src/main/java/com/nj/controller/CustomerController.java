package com.nj.controller;

import com.nj.bean.CustomerBean;
import com.nj.bean.CustomerQuery;
import com.nj.service.CustomerService;
import com.nj.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-07 19:34
 */
@RestController
@RequestMapping("customer")
@Api(description = "客户操作")
public class CustomerController {
    @Resource
    private CustomerService service;

    @GetMapping("getAll")
    @ApiOperation("获取全部客户信息")
    public ResponseUtil getAll(){
        return service.findAll();
    }

    @PostMapping("saveCustomer")
    @ApiOperation("添加用户")
    public ResponseUtil saveCustomer(@RequestBody CustomerBean customer){
        return service.addCus(customer);
    }

    @PutMapping("editCustomer")
    @ApiOperation("添加用户")
    public ResponseUtil editCustomer(@RequestBody CustomerBean customer){
        return service.modifyCusById(customer);
    }

    @GetMapping("editCustomerStatus")
    @ApiOperation("添加用户状态")
    public ResponseUtil editCustomerStatus(Integer cid,Integer status){
        return service.modifyStatusById(cid,status);
    }

    @GetMapping("getAllByPage")
    @ApiOperation("客户列表分页加模糊查询")
    public ResponseUtil getAllByPage(CustomerQuery customerQuery){
        return service.findAllByPage(customerQuery);
    }

    @GetMapping("getCidByCompanyId")
    @ApiOperation("客户列表分页加模糊查询")
    public ResponseUtil getCidByCompanyId(Integer cid){
        return service.findCidByCompanyId(cid);
    }


}
