package com.nj.bean;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-05 20:25
 */
@Data
public class UserQueryBean {
    private String realname;
    private Integer did;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
