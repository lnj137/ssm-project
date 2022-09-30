package com.nj.bean;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-06 19:48
 */
@Data
public class DeptQuery {
    private Integer pageNum;
    private Integer pageSize;
    private Integer status;
    private String dname;
}
