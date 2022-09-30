package com.nj.utils;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-04 09:34
 */
public class Md5Util {
    //加密
    public static String getMd5(String str){
        return SecureUtil.md5(str);
    }


//撒盐
    public static String getMd5Password(String pwd){
        return getMd5(getMd5(getMd5(pwd)+"nanjing")+"dljd");
    }

    @Test
    public void getPwd(){
        System.out.println(getMd5Password("123456"));
    }


}
