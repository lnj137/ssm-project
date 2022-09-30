package com.nj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.bean.DepartmentBean;
import com.nj.bean.DeptQuery;
import com.nj.dao.DeptDao;
import com.nj.service.DeptService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-04 13:44
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    @Override
    public ResponseUtil findById(Integer did) {
        DepartmentBean dept = dao.selectById(did);
        return new ResponseUtil(dept);
    }

    @Override
    public ResponseUtil findAll() {
        List<DepartmentBean> list = dao.selectAll();

        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil addDept(DepartmentBean d) {
        int i = dao.insertDept(d);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil findAllByPage(DeptQuery dq) {
        PageHelper.startPage(dq.getPageNum(),dq.getPageSize());
        List<DepartmentBean> list = dao.selectAllByPage(dq);
        PageInfo<DepartmentBean> page = new PageInfo<>(list);
        ResponseUtil res = new ResponseUtil(page.getList());
        res.setTotal(page.getTotal());
        return res;
    }

    @Override
    public ResponseUtil modifyDeptById(DepartmentBean dept) {
        int i = dao.updateDeptById(dept);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyStatusById(Integer did, Integer status) {
        int i = dao.updateDeptStatusById(did, status);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }
}
