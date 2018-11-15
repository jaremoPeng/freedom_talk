package com.jaremo.freedom_talk.background.service.impl;

import com.jaremo.freedom_talk.background.dao.PermissionDao;
import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述: 权限类的service实现层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 5:09
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public boolean insertPermission(Permission permission) {
        if(permission!=null){
            permissionDao.addPerm(permission);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePermission(Integer id) {
        if(id!=null){
            permissionDao.removePerm(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePermission(Permission permission) {
        if(permission!=null){
            permissionDao.editPerm(permission);
            return true;
        }
        return false;
    }

    @Override
    public List<Permission> selectAllByCondition(Permission permission) {
        return permissionDao.findAllByCondition(permission);
    }
}
