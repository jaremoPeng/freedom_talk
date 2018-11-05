package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void lendCategory(){
        Category category = new Category();
        category.setName("社会");

        categoryService.insertCategory(category);
    }

    @RequestMapping("/editCategory.do")
    public void editCategory(){
        Category category = new Category();
        category.setId(1);
        category.setName("体育");

        categoryService.updateCategory(category);
    }

    @RequestMapping("/delCategory.do")
    public void deleteCategory(){
        categoryService.deleteCategory(1);
    }

    @RequestMapping("/queryCategory.do")
    public void queryCategory(){
        Category category = new Category();
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        System.out.println(categoryList);
    }
}