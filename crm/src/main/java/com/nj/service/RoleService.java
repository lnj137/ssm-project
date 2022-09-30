package com.nj.service;

import com.nj.bean.RoleBean;
import com.nj.utils.ResponseUtil;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 08:24
 */
public interface RoleService {
    //获取全部角色
    ResponseUtil findAll();
    //修改状态
    ResponseUtil modifyStatusById(Integer roleid,Integer status);
    //通过用户id获取角色id
    ResponseUtil getRidByUserid(Integer userid);
    //变更用户权限
    ResponseUtil modifyRoleByUserid(Integer userid, Integer[] rids);
    //添加角色名
    ResponseUtil addRole(RoleBean roleBean);
}
