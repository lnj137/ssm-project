package com.nj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.bean.CompanyBean;
import com.nj.bean.CompanyQuery;
import com.nj.dao.CompanyDao;
import com.nj.service.CompanyService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-06 21:20
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao dao;
    @Override
    public ResponseUtil findAll() {
        List<CompanyBean> list = dao.selectAll();
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil findAllByPage(CompanyQuery companyQuery) {
        PageHelper.startPage(companyQuery.getPageNum(),companyQuery.getPageSize());
        List<CompanyBean> list = dao.selectAllByPage(companyQuery);
        
        PageInfo<CompanyBean> page = new PageInfo<>(list);
        ResponseUtil res = new ResponseUtil(page.getList());
        res.setTotal(page.getTotal());
        return res;
    }



    @Override
    public ResponseUtil addCompany(CompanyBean company) {
        int i = dao.insertCompany(company);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyCompanyById(CompanyBean company) {
        int i = dao.updateCompanyById(company);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyStatusById(Integer companyid, Integer status) {
        int i = dao.updateStatusById(companyid, status);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }
}
