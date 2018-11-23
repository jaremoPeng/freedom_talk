package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Message;
import com.jaremo.freedom_talk.customer.provider.MessageProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 消息类的dao层
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 1:01
 */
@Repository
public interface MessageDao {


    @Insert("insert into tb_message(customer_id,msg_content,msg_time) " +
            "values(#{message.customer.id},#{message.content},#{message.time})")
    void addMsg(@Param("message") Message message);

    @UpdateProvider(type = MessageProvider.class,method = "editMessage")
    void removeMsg(@Param("message") Message message);

    @UpdateProvider(type = MessageProvider.class,method = "editMessage")
    void editMsg(@Param("message") Message message);

    @Results({
            @Result(property = "id",column = "msg_id",id = true),
            @Result(property = "customer",column = "customer_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "content",column = "msg_content"),
            @Result(property = "time",column = "msg_time"),
            @Result(property = "isDelete",column = "isDelete"),
            @Result(property = "isRead",column = "isRead")
    })
    @Select("select * from tb_message where customer_id=#{message.customer.id} and isDelete=#{message.isDelete}")
    List<Message> findMsgByCondition(@Param("message") Message message);
}
