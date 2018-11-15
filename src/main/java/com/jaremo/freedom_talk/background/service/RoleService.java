package com.jaremo.freedom_talk.background.service;

import com.jaremo.freedom_talk.background.domain.Role;

import java.util.List;

/**
 * @描述: 角色类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 3:07
 */
public interface RoleService {

    /**
     * 功能描述 添加角色
     * @author pyj
     * @date 2018/11/15 0015
     * @param role
     * @return boolean
     */
    boolean insertRole(Role role);

    /**
     * 功能描述 删除角色
     * @author pyj
     * @date 2018/11/15 0015
     * @param id
     * @return boolean
     */
    boolean deleteRole(Integer id);

    /**
     * 功能描述 修改角色
     * @author pyj
     * @date 2018/11/15 0015
     * @param role
     * @return boolean
     */
    boolean updateRole(Role role);

    /**
     * 功能描述 根据条件查询角色
     * @author pyj
     * @date 2018/11/15 0015
     * @param role
     * @return java.util.List<com.jaremo.freedom_talk.background.domain.Role>
     */
    List<Role> selectRoleByCondition(Role role);
}
