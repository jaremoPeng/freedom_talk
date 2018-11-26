package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 后台控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 5:15
 */
@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

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
    public String gotoBgCategoryList(ModelMap modelMap){
        Category category = new Category();
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        modelMap.addAttribute("categoryList",categoryList);
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