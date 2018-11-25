package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.provider.LeaveWordReplyProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 留言回复类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 4:10
 */
@Repository
public interface LeaveWordReplyDao {

    @Insert("insert into tb_lwreply(leaveword_id,from_id,to_id,lwr_content,lwr_time) " +
            "values(#{leaveWordReply.leaveWord.id},#{leaveWordReply.fromCustomer.id},#{leaveWordReply.toCustomer.id},#{leaveWordReply.replyContent}," +
            "#{leaveWordReply.replyTime})")
    void addLeaveWordReply(@Param("leaveWordReply") LeaveWordReply leaveWordReply);

    @Results({
            @Result(id = true,property = "id",column = "lwr_id"),
            @Result(property = "leaveWord",column = "leaveword_id",javaType = LeaveWord.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.LeaveWordDao.findLeaveWordById")),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "replyContent",column = "lwr_content"),
            @Result(property = "replyTime",column = "lwr_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = LeaveWordReplyProvider.class,method = "findLeaveWordReplyByCondition")
    List<LeaveWordReply> findLeaveWordReplyByCondition(@Param("leaveWordReply") LeaveWordReply leaveWordReply);


    @UpdateProvider(type = LeaveWordReplyProvider.class,method = "editLeaveWordReply")
    void removeLeaveWordReply(@Param("leaveWordReply") LeaveWordReply leaveWordReply);

    @Results({
            @Result(id = true,property = "id",column = "lwr_id"),
            @Result(property = "leaveWord",column = "leaveword_id",javaType = LeaveWord.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.LeaveWordDao.findLeaveWordById")),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "replyContent",column = "lwr_content"),
            @Result(property = "replyTime",column = "lwr_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_lwreply where leaveword_id=#{lw_id} and isDelete=1")
    List<LeaveWordReply> findLeaveWordReplyByLwid(Integer lw_id);
}
