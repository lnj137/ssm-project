package com.nj.service;

import com.nj.bean.RecoderBean;
import com.nj.bean.RecoderQuery;
import com.nj.utils.ResponseUtil;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 19:10
 */
public interface RecoderService {
    //模糊查询加分页
    ResponseUtil findAll(RecoderQuery recoderQuery);
    //添加
    ResponseUtil addRecoder(RecoderBean recoderBean);
    //修改
    ResponseUtil modifyRecoder(RecoderBean recoderBean);
}
