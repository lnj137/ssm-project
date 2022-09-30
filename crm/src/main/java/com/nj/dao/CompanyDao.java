package com.nj.dao;

import com.nj.bean.CompanyBean;
import com.nj.bean.CompanyQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-06 21:16
 */
public interface CompanyDao {
    //获取所有公司信息，
    List<CompanyBean> selectAll();
    //分页加模糊查询获取公司信息
    List<CompanyBean> selectAllByPage(CompanyQuery companyQuery);
    //添加公司信息
    int insertCompany(CompanyBean c);
    //修改公司信息
    int updateCompanyById(CompanyBean c);
    //修改公司状态
    int updateStatusById(@Param("cid") Integer companyid, @Param("status") Integer status);
}
