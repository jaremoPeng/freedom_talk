package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.provider.NoteProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 帖子数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:23
 */
@Repository
public interface NoteDao {

    @InsertProvider(type = NoteProvider.class,method = "addNote")
    void addNote(@Param("note") Note note);

    @UpdateProvider(type = NoteProvider.class,method = "editNote")
    void editNote(@Param("note") Note note);

    @Results({
            @Result(property = "id",column = "note_id",id = true),
            @Result(property = "title",column = "note_title"),
            @Result(property = "content",column = "note_content"),
            @Result(property = "customer",column = "customer_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "browserNum",column = "note_browserNum"),
            @Result(property = "commentNum",column = "note_commentNum"),
            @Result(property = "img",column = "note_img"),
            @Result(property = "category",column = "note_category",javaType = Category.class,one = @One(select = "com.jaremo.freedom_talk.background.dao.CategoryDao.findCategoryById")),
            @Result(property = "time",column = "note_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = NoteProvider.class,method = "findAllByCondition")
    List<Note> findAllByCondition(@Param("note") Note note);

    @Results({
            @Result(property = "id",column = "note_id",id = true),
            @Result(property = "title",column = "note_title"),
            @Result(property = "content",column = "note_content"),
            @Result(property = "customer",column = "customer_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "browserNum",column = "note_browserNum"),
            @Result(property = "commentNum",column = "note_commentNum"),
            @Result(property = "img",column = "note_img"),
            @Result(property = "category",column = "note_category",javaType = Category.class,one = @One(select = "com.jaremo.freedom_talk.background.dao.CategoryDao.findCategoryById")),
            @Result(property = "time",column = "note_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_note where note_id=#{id}")
    Note findNoteById(Integer id);
}
