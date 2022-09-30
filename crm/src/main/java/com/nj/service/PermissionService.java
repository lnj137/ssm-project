package com.nj.service;

import com.nj.bean.PermissionBean;
import com.nj.utils.ResponseUtil;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 13:07
 */
public interface PermissionService {
    ResponseUtil findAll();
    ResponseUtil findPidByRid(Integer roleid);
    ResponseUtil modifyRolePs(Integer roleid,Integer[] pids);
    ResponseUtil addPermission(PermissionBean per);
    ResponseUtil removePermissionByPid(Integer pid);
    ResponseUtil editPermission(PermissionBean permission);
}
