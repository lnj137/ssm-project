package com.nj.dao;

import com.nj.bean.PermissionBean;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 12:58
 */
public interface PermissionDao {
    //获取权限树
    List<PermissionBean> selectAll();
    //获取角色对应的权限
    List<Integer> selectPidByRid(Integer roleid);
    //对角色的权限进行更改
    int deleteRolePsByRid(Integer roleid);
    int insertRolePs(@Param("roleid") Integer roleid, @Param("pids") Integer[] pids);

    //添加子菜单
    int insertPermission(PermissionBean per);
    //删除菜单
    int deletePermissionByPid(Integer pid);
    //修改菜单
    int updatePermissionByPid(PermissionBean permission);
    //查询所有的权限，专门用于超级管理
    List<PermissionBean> selecrAllPermission();
}
