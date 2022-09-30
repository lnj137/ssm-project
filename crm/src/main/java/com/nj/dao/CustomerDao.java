package com.nj.dao;

import com.nj.bean.CustomerBean;
import com.nj.bean.CustomerQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-07 19:30
 */
public interface CustomerDao {
    //获取所有用户信息
    List<CustomerBean> selectAll();
    //添加客户信息
    int insertCus(CustomerBean customerBean);
    //修改客户信息
    int updateCusById(CustomerBean customerBean);
    //修改用户状态
    int updateStatusById(@Param("cid") Integer cid, @Param("status") Integer status);
    //分页加模糊查询
    List<CustomerBean> selectAllByPage(CustomerQuery customerQuery);
    //通过公司id查询客户
    List<CustomerBean> selectByCompanyId(Integer companyid);
}
