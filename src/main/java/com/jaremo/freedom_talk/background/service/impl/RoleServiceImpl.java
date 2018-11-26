package com.jaremo.freedom_talk.background.service.impl;

import com.jaremo.freedom_talk.background.dao.PermissionDao;
import com.jaremo.freedom_talk.background.dao.RoleDao;
import com.jaremo.freedom_talk.background.dao.RolePermRelationDao;
import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.domain.Role;
import com.jaremo.freedom_talk.background.domain.RolePermRelation;
import com.jaremo.freedom_talk.background.service.RoleService;
import com.jaremo.freedom_talk.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: 角色类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 3:12
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermRelationDao rolePermRelationDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public boolean insertRole(Role role) {
        if(role.getName()!=null){
            role.setId(Integer.parseInt(RandomUtil.getRandom(4)));
            roleDao.addRole(role);
            for (Permission perm:role.getPermList()) { // 中间表添加记录
                rolePermRelationDao.addRolePermRelation(role.getId(),perm.getId());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRole(Integer id) {
        if(id!=null){
            roleDao.removeRole(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRole(Role role) {
        if(role!=null){
            roleDao.editRole(role);
            rolePermRelationDao.removeRole(role.getId());
            insertRole(role);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> selectRoleByCondition(Role role) {
        List<Role> roleList = roleDao.findRoleByCondition(role);
        for (Role tempRole:roleList) {
            List<RolePermRelation> rolePermRelationList = rolePermRelationDao.findPidByRid(tempRole.getId()); // 根据中间表封装该角色下的所有权限
            List<Permission> permissions = selectPermByPid(rolePermRelationList); // 根据角色与权限的中间表 的权限id获取权限信息
            tempRole.setPermList(permissions); // 封装权限
        }
        return roleList;
    }

    public List<Permission> selectPermByPid(List<RolePermRelation> rolePermRelationList){
        List<Permission> permList = new ArrayList<>();
        for (RolePermRelation rpl:rolePermRelationList) {
            Permission perm = permissionDao.findPermById(rpl.getPid());
            permList.add(perm);
        }
        return permList;
    }
}
