package com.jaremo.freedom_talk.background.provider;

import com.jaremo.freedom_talk.background.domain.Category;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 分类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 4:57
 */
public class CategoryProvider {

    public String findAll(Map map){
        Category category = (Category) map.get("category");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_category");
        if(category.getId()!=null){
            sql.WHERE("cate_id=#{category.id}");
        }
        if(category.getName()!=null){
            sql.WHERE("cate_name=#{category.name}");
        }
        if(category.getIsDelete()!=null){
            sql.WHERE("isDelete=#{category.isDelete}");
        }
        return sql.toString();
    }

    public String findByKw(Map map){
        Category category = (Category) map.get("category");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_category");
        if(category.getName()!=null){
            sql.WHERE("cate_name like CONCAT('%',#{category.name},'%')");
        }
        if(category.getIsDelete()!=null){
            sql.WHERE("isDelete=#{category.isDelete}");
        }
        return sql.toString();
    }
}
