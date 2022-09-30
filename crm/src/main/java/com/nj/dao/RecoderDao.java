package com.nj.dao;

import com.nj.bean.RecoderBean;
import com.nj.bean.RecoderQuery;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 18:31
 */
public interface RecoderDao {
    //模糊查询分页
    List<RecoderBean> selectAll(RecoderQuery recoderQuery);
    //添加
    int insertRecoder(RecoderBean recoderBean);
    //修改
    int updateRecoder(RecoderBean recoderBean);
}
