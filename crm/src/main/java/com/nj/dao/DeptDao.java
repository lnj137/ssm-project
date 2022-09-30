package com.nj.dao;

import com.nj.bean.DepartmentBean;
import com.nj.bean.DeptQuery;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 19:32
 */
public interface DeptDao {
    DepartmentBean selectById(Integer id);

    List<DepartmentBean> selectAll();

    int insertDept(DepartmentBean dept);

    List<DepartmentBean> selectAllByPage(DeptQuery dq);//分页加模糊查询

    int updateDeptById(DepartmentBean dept);

    int updateDeptStatusById(Integer did,Integer status);
}
