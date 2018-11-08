package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Follow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 关注类的dao层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 2:20
 */
@Repository
public interface FollowDao {

    @Insert("insert into tb_follow(customer_id,moderator_id) " +
            "values(#{follow.customer.id},#{follow.moderator.id})")
    void addFollow(@Param("follow") Follow follow);

    @Delete("delete from tb_follow where customer_id=#{follow.customer.id} and moderator_id=#{follow.moderator.id}")
    void removeFollow(@Param("follow") Follow follow);

    @Results({
            @Result(property = "id",column = "fol_id",id = true),
            @Result(property = "customer",column = "customer_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "moderator",column = "moderator_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById"))
    })
    @Select("select * from tb_follow where customer_id=#{follow.customer.id}")
    List<Follow> findFollowByCondition(@Param("follow") Follow follow);

}
