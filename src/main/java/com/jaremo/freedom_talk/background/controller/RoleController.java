package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.domain.Role;
import com.jaremo.freedom_talk.background.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: 角色控制层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--下午 4:03
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/lendRole.do")
    public void lendRole(){
        Permission perm1 = new Permission();
        perm1.setId(1);
        Permission perm2 = new Permission();
        perm2.setId(2);

        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(perm1);
        permissionList.add(perm2);

        Role role = new Role();
        role.setPermList(permissionList);
        role.setName("youke");

        roleService.insertRole(role);
    }

    @RequestMapping("/delRole.do")
    public void delRole(){
//        Role role = new Role();
//        role.setId(1);
        roleService.deleteRole(2850);
    }

    @RequestMapping("/editRole.do")
    public void editRole(){
        Role role = new Role();
        role.setName("admin");
        role.setId(2850);

        roleService.updateRole(role);
    }

    @RequestMapping("/queryRole.do")
    public void queryRole(){
        Role role = new Role();
        role.setId(2850);
        role.setIsDelete(1);

        List<Role> roles = roleService.selectRoleByCondition(role);
        System.out.println(roles);
    }
}
