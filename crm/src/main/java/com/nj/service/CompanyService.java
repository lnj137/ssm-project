package com.nj.service;

import com.nj.bean.CompanyBean;
import com.nj.bean.CompanyQuery;
import com.nj.utils.ResponseUtil;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-06 21:19
 */
public interface CompanyService {
    //获取所有公司信息
    ResponseUtil findAll();
    //分页+模糊查询获取公司信息
    ResponseUtil findAllByPage(CompanyQuery companyQuery);
    //添加客户公司信息
    ResponseUtil addCompany(CompanyBean company);
    //修改用户信息
    ResponseUtil modifyCompanyById(CompanyBean company);
    //修改用户状态
    ResponseUtil modifyStatusById(Integer companyid,Integer status);
}
