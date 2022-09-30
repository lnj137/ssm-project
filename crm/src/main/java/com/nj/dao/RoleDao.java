package com.nj.dao;

import com.nj.bean.RoleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-09 16:57
 */
public interface RoleDao {
    //查询所有
    List<RoleBean> selectAll();
    //修改状态
    int updateStatusById(Integer roleid,Integer status);
    //通过用户id进行查询
    List<Integer> selectRidByUserid(Integer userid);

    //修改用户权限表，无法直接修改，先删除在添加
    int deleteRole(Integer userid);//根据当前用户的id删除当前用户的角色
    int insertRole(@Param("userid") Integer userid, @Param("rids")Integer[] rids);//添加用户的角色，一个用户对应多个角色

    //添加角色
    int insertRoleName(RoleBean roleBean);
}
