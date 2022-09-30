package com.nj.bean;

import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 18:32
 */
@Data
public class RecoderQuery {
    private Integer userid;
    private Integer companyid;
    private Integer customerid;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
