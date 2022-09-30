package com.nj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.bean.RecoderBean;
import com.nj.bean.RecoderQuery;
import com.nj.dao.RecoderDao;
import com.nj.service.RecoderService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 19:10
 */
@Service
public class RecoderServiceImpl implements RecoderService {
    @Autowired
    private RecoderDao dao;
    @Override
    public ResponseUtil findAll(RecoderQuery recoderQuery) {
        PageHelper.startPage(recoderQuery.getPageNum(),recoderQuery.getPageSize());
        List<RecoderBean> list = dao.selectAll(recoderQuery);

        PageInfo<RecoderBean> page = new PageInfo<>(list);
        ResponseUtil res = new ResponseUtil(page.getList());
        res.setTotal(page.getTotal());
        return res;
    }

    @Override
    public ResponseUtil addRecoder(RecoderBean recoderBean) {
        int i = dao.insertRecoder(recoderBean);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil modifyRecoder(RecoderBean recoderBean) {
        int i = dao.updateRecoder(recoderBean);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }
}
