package com.jaremo.freedom_talk.background.service.impl;

import com.jaremo.freedom_talk.background.dao.CategoryDao;
import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述: 分类服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 5:07
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean insertCategory(Category category) {

        List<Category> categories = selectAllByCondition(category); // 先查询是否重名的分类
        if(categories == null || categories.size() == 0){
            categoryDao.addCategory(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        if(category!=null){
            categoryDao.editCategory(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        if(id!=null){
            categoryDao.removeCategory(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> selectAllByCondition(Category category) {
        if (category!=null){
            List<Category> categoryList = categoryDao.findAllByCondition(category);
            return categoryList;
        }
        return null;
    }

    @Override
    public boolean updateCate(Category category) {
        if(category.getIsDelete()!=null && category.getId()!=null){
            categoryDao.editCate(category);
            return true;
        }
        return false;
    }
}
