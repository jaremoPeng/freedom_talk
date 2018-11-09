package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Chat;
import com.jaremo.freedom_talk.customer.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 聊天类的dao层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 2:42
 */
@Repository
public interface ChatDao {

    @Insert("insert into tb_chat(ch_content,from_id,to_id,ch_time) " +
            "values(#{chat.content},#{chat.fromCustomer.id},#{chat.toCustomer.id},#{chat.time})")
    void addChat(@Param("chat") Chat chat);

    @Delete("delete from tb_chat where from_id=#{chat.fromCustomer.id} and to_id=#{chat.toCustomer.id}")
    void removeChat(@Param("chat") Chat chat);

    @Results({
            @Result(property = "id",column = "ch_id",id = true),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "content",column = "ch_content"),
            @Result(property = "time",column = "ch_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_chat where from_id=#{chat.fromCustomer.id} and to_id=#{chat.toCustomer.id}")
    List<Chat> findChatByCondition(@Param("chat") Chat chat);
}
