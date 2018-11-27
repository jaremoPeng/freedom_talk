package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Permission;
import com.jaremo.freedom_talk.background.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/lendPerm.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendPerm(String permname,String permurl,String permsign){
        Permission permission = new Permission();
        permission.setName(permname);
        permission.setUrl(permurl);
        permission.setSign(permsign);

        boolean result = permissionService.insertPermission(permission);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/delPerm.do",method = RequestMethod.POST)
    @ResponseBody
    public String delPerm(Integer permid){

        permissionService.deletePermission(permid);
        return "";
    }

    @RequestMapping(value = "/editPerm.do",method = RequestMethod.POST)
    @ResponseBody
    public String editPerm(Integer permid,String permname,String permurl,String permsign){
        Permission permission = new Permission();
        permission.setName(permname);
        permission.setUrl(permurl);
        permission.setSign(permsign);
        permission.setId(permid);

        permissionService.updatePermission(permission);
        return "";
    }

    @RequestMapping("/gotoBgPermAdd.do")
    public String gotoBgPermAdd(){
        return "bg_perm_add";
    }

    @RequestMapping("/gotoBgPermEdit.do")
    public String gotoBgPermEdit(Integer permid , ModelMap modelMap){
        Permission permission = new Permission();
        permission.setId(permid);
        List<Permission> permissionList = permissionService.selectAllByCondition(permission);
        modelMap.addAttribute("permission",permissionList.get(0));
        return "bg_perm_edit";
    }

    @RequestMapping("/gotoBgPermManage.do")
    public String gotoBgPermManage(ModelMap modelMap){
        Permission permission = new Permission();
        List<Permission> permissionList = permissionService.selectAllByCondition(permission);
        modelMap.addAttribute("permissionList",permissionList);
        return "bg_perm_manage";
    }
}
