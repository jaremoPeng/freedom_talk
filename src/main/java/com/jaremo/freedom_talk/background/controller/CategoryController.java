package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @描述: 分类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 5:15
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/lendCategory.do")
    @ResponseBody
    public String lendCategory(String catename){
        Category category = new Category();
        category.setName(catename);

        boolean result = categoryService.insertCategory(category);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/editCategory.do",method = RequestMethod.POST)
    @ResponseBody
    public String editCategory(Integer cateid,String catename){
        Category category = new Category();
        category.setId(cateid);
        category.setName(catename);

        boolean result = categoryService.updateCategory(category);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/editCate.do",method = RequestMethod.POST)
    @ResponseBody
    public String editCate(Integer cateid){
        Category category = new Category();
        category.setId(cateid);
        category.setIsDelete(1);

        boolean result = categoryService.updateCate(category);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping("/gotoBgCategoryEdit.do")
    public String gotoBgCategoryList(Integer categoryid, ModelMap modelMap){
        Category category = new Category();
        category.setId(categoryid);
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        modelMap.addAttribute("category",categoryList.get(0));
        return "bg_category_edit";
    }

    @RequestMapping(value = "/delCategory.do",method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(Integer cateid){
        boolean result = categoryService.deleteCategory(cateid);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping("/queryCategory.do")
    public void queryCategory(){
        Category category = new Category();
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        System.out.println(categoryList);
    }
}