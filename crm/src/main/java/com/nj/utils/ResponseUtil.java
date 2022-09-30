package com.nj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-03 18:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
    private Integer code = 200;
    private String msg = "请求成功";
    private Object result;
    private Long total;

    public ResponseUtil(Object result) {
        this.result = result;
    }

    public ResponseUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
