package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.provider.LeaveWordProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 留言类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:33
 */
@Repository
public interface LeaveWordDao {

    @Insert("insert into tb_leaveword(lw_content,from_id,to_id,lw_time) " +
            "values (#{leaveWord.content},#{leaveWord.fromCustomer.id},#{leaveWord.toCustomer.id},#{leaveWord.time})")
    void addLeaveWord(@Param("leaveWord") LeaveWord leaveWord);

    @Results({
            @Result(id = true,property = "id",column = "lw_id"),
            @Result(property = "content",column = "lw_content"),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class, one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "time",column = "lw_time"),
            @Result(property = "isStart",column = "isStart"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_leaveword where from_id = #{offId}")
    List<LeaveWord> findAllByOfficialId(String offId); // 根据官方的id查询用户的留言板是否开启

    @Results({
            @Result(id = true,property = "id",column = "lw_id"),
            @Result(property = "content",column = "lw_content"),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class, one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class, one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "time",column = "lw_time"),
            @Result(property = "isStart",column = "isStart"),
            @Result(property = "isDelete",column = "isDelete"),
            @Result(property = "leaveWordReplyList",column = "lw_id",javaType = List.class,many = @Many(select = "com.jaremo.freedom_talk.customer.dao.LeaveWordReplyDao.findLeaveWordReplyByLwid"))
    })
    @SelectProvider(type = LeaveWordProvider.class , method = "findLeaveWordByCondition")
    List<LeaveWord> findLeaveWordByCondition(@Param("leaveWord") LeaveWord leaveWord);

    @UpdateProvider(type = LeaveWordProvider.class,method = "editLeaveWord")
    void editLeaveWordByCondition(@Param("leaveWord") LeaveWord leaveWord);

    @Results({
            @Result(id = true,property = "id",column = "lw_id"),
            @Result(property = "content",column = "lw_content"),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class, one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class, one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "time",column = "lw_time"),
            @Result(property = "isStart",column = "isStart"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_leaveword where lw_id = #{id}")
    List<LeaveWord> findLeaveWordById(Integer id);
}
