package com.nj.service.impl;

import com.nj.bean.PermissionBean;
import com.nj.dao.PermissionDao;
import com.nj.service.PermissionService;
import com.nj.utils.Commons;
import com.nj.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date:2022-09-12 13:07
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao dao;

    @Override
    public ResponseUtil findAll() {
        List<PermissionBean> list = dao.selectAll();
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil findPidByRid(Integer roleid) {
        List<Integer> list = dao.selectPidByRid(roleid);
        return new ResponseUtil(list);
    }

    @Override
    public ResponseUtil modifyRolePs(Integer roleid, Integer[] pids) {
        int i = dao.deleteRolePsByRid(roleid);
        int i1 = dao.insertRolePs(roleid, pids);
        if ((i+i1)>1) {
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil addPermission(PermissionBean per) {
        int i = dao.insertPermission(per);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil removePermissionByPid(Integer pid) {
        int i = dao.deletePermissionByPid(pid);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }

    @Override
    public ResponseUtil editPermission(PermissionBean permission) {
        int i = dao.updatePermissionByPid(permission);
        if (i>0){
            return new ResponseUtil();
        }
        return new ResponseUtil(Commons.ERROR,Commons.ERROR_MSG);
    }
}
