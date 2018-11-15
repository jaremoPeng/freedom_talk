package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 权限类控制层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 5:14
 */
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/lendPerm.do")
    public void lendPerm(){
        Permission permission = new Permission();
        permission.setName("customer:delete");
        permission.setUrl("/deleteCus.do");
        permission.setSign("cus_del");

        permissionService.insertPermission(permission);
    }

    @RequestMapping("/delPerm.do")
    public void delPerm(){
        permissionService.deletePermission(2);
    }

    @RequestMapping("/editPerm.do")
    public void editPerm(){
        Permission permission = new Permission();
        permission.setName("customer:update");
        permission.setUrl("/updateCus.do");
        permission.setSign("cus_update");
        permission.setId(3);

        permissionService.updatePermission(permission);
    }

    @RequestMapping("/queryPerm.do")
    public void queryPerm(){
        Permission permission = new Permission();
        permission.setId(1);
        permission.setIsDelete(1);

        List<Permission> permissionList = permissionService.selectAllByCondition(permission);
        System.out.println(permissionList);
    }
}
