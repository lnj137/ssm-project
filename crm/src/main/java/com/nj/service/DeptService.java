package com.nj.service;

import com.nj.bean.DepartmentBean;
import com.nj.bean.DeptQuery;
import com.nj.utils.ResponseUtil;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-04 13:43
 */
public interface DeptService {
    //通过id查询部门信息，用来获取每个用户的部门
    ResponseUtil findById(Integer did);
    //获取所有的部门名称
    ResponseUtil findAll();
    //新增部门
    ResponseUtil addDept(DepartmentBean d);
    //分页加模糊查询
    ResponseUtil findAllByPage(DeptQuery dq);
    //通过部门id修改部门名称
    ResponseUtil modifyDeptById(DepartmentBean dept);
    //通过id修改部门状态
    ResponseUtil modifyStatusById(Integer did,Integer status);
}
