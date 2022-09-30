package com.nj.bean;

import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-08 11:11
 */
@Data
public class CustomerQuery {
    private Integer companyid;
    private String cname;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
