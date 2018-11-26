package com.jaremo.freedom_talk.background.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述: 后台控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 5:15
 */
@Controller
public class AdminController {

    @RequestMapping("/gotoBgCusManage.do")
    public String gotoBgCusManage(){
        return "bg_cus_manage";
    }

    @RequestMapping("/gotoBgBmManage.do")
    public String gotoBgBmManage(){
        return "bg_bm_manage";
    }

    @RequestMapping("/gotoBgCategoryAdd.do")
    public String gotoBgCategoryAdd(){
        return "bg_category_add";
    }

    @RequestMapping("/gotoBgCategoryList.do")
    public String gotoBgCategoryList(){
        return "bg_category_list";
    }

    @RequestMapping("/gotoBgACAdd.do")
    public String gotoBgACAdd(){
        return "bg_ac_add";
    }

    @RequestMapping("/gotoBgACList.do")
    public String gotoBgACList(){
        return "bg_ac_list";
    }

    @RequestMapping("/gotoBgRoleManage.do")
    public String gotoBgRoleManage(){
        return "bg_role_manage";
    }

    @RequestMapping("/gotoBgPermManage.do")
    public String gotoBgPermManage(){
        return "bg_perm_manage";
    }
}