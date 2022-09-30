package com.nj.service.impl;

import com.nj.bean.RoleBean;
import com.nj.dao.RoleDao;
import com.nj.service.RoleService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 08:25
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao dao;
    @Override
    public ResponseUtil findAll() {
        List<RoleBean> list = dao.selectAll();
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil modifyStatusById(Integer roleid,Integer status) {
        int i = dao.updateStatusById(roleid, status);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil getRidByUserid(Integer userid) {
        List<Integer> list = dao.selectRidByUserid(userid);
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil modifyRoleByUserid(Integer userid, Integer[] rids) {
        dao.deleteRole(userid);
        dao.insertRole(userid, rids);
        return new ResponseUtil();
    }

    @Override
    public ResponseUtil addRole(RoleBean roleBean) {
        int i = dao.insertRoleName(roleBean);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

}
