package com.jaremo.freedom_talk.background.service;

import com.jaremo.freedom_talk.background.domain.Category;

import java.util.List;

/**
 * @描述:
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 3:38
 */
public interface CategoryService {

    /**
     * 功能描述 添加分类
     * @author pyj
     * @date 2018/11/5 0005
     * @param category
     * @return boolean
     */
    boolean insertCategory(Category category);

    /**
     * 功能描述 修改分类
     * @author pyj
     * @date 2018/11/5 0005
     * @param category
     * @return boolean
     */
    boolean updateCategory(Category category);

    /**
     * 功能描述 找回分类
     * @author pyj
     * @date 2018/11/5 0005
     * @param category
     * @return boolean
     */
    boolean updateCate(Category category);

    /**
     * 功能描述 根据id删除分类
     * @author pyj
     * @date 2018/11/5 0005
     * @param id
     * @return boolean
     */
    boolean deleteCategory(Integer id);

    /**
     * 功能描述 根据条件查询分类
     * @author pyj
     * @date 2018/11/5 0005
     * @param category
     * @return java.util.List<com.jaremo.freedom_talk.background.domain.Category>
     */
    List<Category> selectAllByCondition(Category category);

}
