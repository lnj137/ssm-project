package com.nj.bean;

import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-07 16:42
 */
@Data
public class CompanyQuery {
    private Integer pageNum;
    private Integer pageSize;
    private String cname;
    private String address;
    private Integer status;
}
