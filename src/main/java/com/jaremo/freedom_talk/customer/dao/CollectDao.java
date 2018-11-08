package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Collect;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.provider.CollectProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 收藏类的dao层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:05
 */
@Repository
public interface CollectDao {

    @Insert("insert into tb_collect(customer_id,note_id,col_time) " +
            "values(#{collect.customer.id},#{collect.note.id},#{collect.time})")
    void addCollect(@Param("collect") Collect collect);

    @Update("update tb_collect set isDelete=0 where note_id=#{collect.note.id} and customer_id=#{collect.customer.id}")
    void removeCollect(@Param("collect") Collect collect);

    @UpdateProvider(type = CollectProvider.class,method = "editCollect")
    void editCollect(@Param("collect") Collect collect);

    @Results({
            @Result(property = "id",column = "col_id",id = true),
            @Result(property = "customer",column = "customer_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "note",column = "note_id",javaType = Note.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.NoteDao.findNoteById")),
            @Result(property = "time",column = "col_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = CollectProvider.class, method = "findAllByCondition")
    List<Collect> findAllByCondition(@Param("collect") Collect collect);
}
