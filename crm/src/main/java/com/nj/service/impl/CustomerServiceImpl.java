package com.nj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.bean.CompanyBean;
import com.nj.bean.CustomerBean;
import com.nj.bean.CustomerQuery;
import com.nj.dao.CustomerDao;
import com.nj.service.CustomerService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-07 19:33
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;
    @Override
    public ResponseUtil findAll() {
        List<CustomerBean> list = dao.selectAll();
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil addCus(CustomerBean customerBean) {
        int i = dao.insertCus(customerBean);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyCusById(CustomerBean customerBean) {
        int i = dao.updateCusById(customerBean);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyStatusById(Integer cid, Integer status) {
        int i = dao.updateStatusById(cid, status);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil findAllByPage(CustomerQuery customerQuery) {
        PageHelper.startPage(customerQuery.getPageNum(),customerQuery.getPageSize());
        List<CustomerBean> list = dao.selectAllByPage(customerQuery);
        PageInfo<CustomerBean> page = new PageInfo<>(list);
        ResponseUtil res = new ResponseUtil(page.getList());
        res.setTotal(page.getTotal());
        return res;
    }

    @Override
    public ResponseUtil findCidByCompanyId(Integer companyid) {
        List<CustomerBean> list = dao.selectByCompanyId(companyid);
        return new ResponseUtil(list);
    }
}
