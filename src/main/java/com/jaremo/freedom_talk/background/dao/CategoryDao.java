package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.provider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 分类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 3:44
 */
@Repository
public interface CategoryDao {

    @Insert("insert into tb_category(cate_name) values(#{category.name})")
    void addCategory(@Param("category") Category category);

    @Update("update tb_category set cate_name=#{category.name} where cate_id = #{category.id}")
    void editCategory(@Param("category") Category category);

    @Update("update tb_category set isDelete=0 where cate_id = #{id}")
    void removeCategory(Integer id);

    @Results({
            @Result(property = "id",column = "cate_id",id = true),
            @Result(property = "name",column = "cate_name"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_category where cate_id = #{id}")
    Category findCategoryById(Integer id);

    @Results({
            @Result(property = "id",column = "cate_id",id = true),
            @Result(property = "name",column = "cate_name"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = CategoryProvider.class,method = "findAll")
    List<Category> findAllByCondition(@Param("category") Category category);
}
