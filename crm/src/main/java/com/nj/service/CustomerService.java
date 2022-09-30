package com.nj.service;

import com.nj.bean.CustomerBean;
import com.nj.bean.CustomerQuery;
import com.nj.utils.ResponseUtil;
import org.apache.ibatis.annotations.Param;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-07 19:33
 */
public interface CustomerService {
    //获取所有客户信息
    ResponseUtil findAll();
    //添加用户信息
    ResponseUtil addCus(CustomerBean customerBean);
    //修改用户信息
    ResponseUtil modifyCusById(CustomerBean customerBean);
    //修改用户状态
    ResponseUtil modifyStatusById(Integer cid, Integer status);
    //分页加模糊查询
    ResponseUtil findAllByPage(CustomerQuery customerQuery);
    //通过公司id查询客户
    ResponseUtil findCidByCompanyId(Integer companyid);
}
