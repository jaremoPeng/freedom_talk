package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.domain.Role;
import com.jaremo.freedom_talk.background.service.PermissionService;
import com.jaremo.freedom_talk.background.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/lendRole.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendRole(String rolename,String perms){
        Role role = new Role();
        role.setName(rolename);
        String[] split = perms.split(",");

        List<Permission> permList = new ArrayList<>();
        for(int i=0;i<split.length;i++){
            Permission permission = new Permission();
            permission.setId(Integer.parseInt(split[i]));
            permList.add(permission);
        }
        role.setPermList(permList);

        boolean result = roleService.insertRole(role);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/delRole.do",method = RequestMethod.POST)
    @ResponseBody
    public String delRole(Integer roleid){
        boolean result = roleService.deleteRole(roleid);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/editRole.do",method = RequestMethod.POST)
    @ResponseBody
    public String editRole(Integer roleid,String rolename,String perms){
        Role role = new Role();
        role.setName(rolename);
        role.setId(roleid);
        String[] split = perms.split(",");

        List<Permission> permList = new ArrayList<>();
        for(int i=0;i<split.length;i++){
            Permission permission = new Permission();
            permission.setId(Integer.parseInt(split[i]));
            permList.add(permission);
        }
        role.setPermList(permList);

        roleService.updateRole(role);
        return null;
    }
    @RequestMapping("/gotoBgRoleAdd.do")
    public String gotoBgRoleAdd(ModelMap modelMap){
        Role role = new Role();
        role.setIsDelete(1);

        List<Role> roles = roleService.selectRoleByCondition(role);
        modelMap.addAttribute("role",roles.get(0));

        Permission permission = new Permission();
        permission.setIsDelete(1);
        List<Permission> permissionList = permissionService.selectAllByCondition(permission);
        modelMap.addAttribute("permissionList",permissionList);
        return "bg_role_add";
    }

    @RequestMapping("/gotoBgRoleEdit.do")
    public String gotoBgRoleEdit(Integer roleid , ModelMap modelMap){
        Role role = new Role();
        role.setId(roleid);
        role.setIsDelete(1);
        List<Role> roles = roleService.selectRoleByCondition(role);
        modelMap.addAttribute("role",roles.get(0));

        Permission permission = new Permission();
        permission.setIsDelete(1);
        List<Permission> permissionList = permissionService.selectAllByCondition(permission);
        modelMap.addAttribute("permissionList",permissionList);
        return "bg_role_edit";
    }

    @RequestMapping("/gotoBgRoleManage.do")
    public String gotoBgRoleManage(ModelMap modelMap){
        Role role = new Role();
        List<Role> roles = roleService.selectRoleByCondition(role);
        modelMap.addAttribute("roles",roles);
        return "bg_role_manage";
    }
}
