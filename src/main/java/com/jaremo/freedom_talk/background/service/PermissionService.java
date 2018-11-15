package com.jaremo.freedom_talk.background.service;

import com.jaremo.freedom_talk.background.domain.Permission;

import java.util.List;

/**
 * @描述: 权限服务层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 5:05
 */
public interface PermissionService {

    /**
     * 功能描述 添加权限
     * @author pyj
     * @date 2018/11/15 0015
     * @param permission
     * @return boolean
     */
    boolean insertPermission(Permission permission);

    /**
     * 功能描述 删除权限
     * @author pyj
     * @date 2018/11/15 0015
     * @param id
     * @return boolean
     */
    boolean deletePermission(Integer id);

    /**
     * 功能描述 修改权限
     * @author pyj
     * @date 2018/11/15 0015
     * @param permission
     * @return boolean
     */
    boolean updatePermission(Permission permission);

    /**
     * 功能描述 根据条件查询权限
     * @author pyj
     * @date 2018/11/15 0015
     * @param permission
     * @return java.util.List<com.jaremo.freedom_talk.background.domain.Permission>
     */
    List<Permission> selectAllByCondition(Permission permission);
}
