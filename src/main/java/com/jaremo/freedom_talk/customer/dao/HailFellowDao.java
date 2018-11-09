package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.HailFellow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 好友类的dao层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 1:23
 */
@Repository
public interface HailFellowDao {

    @Insert("insert into tb_hail_fellow (from_id,to_id,hf_remarks) " +
            "values(#{hailFellow.fromCustomer.id},#{hailFellow.toCustomer.id},#{hailFellow.remarks})")
    void addHailFellow(@Param("hailFellow") HailFellow hailFellow);

    @Delete("delete from tb_hail_fellow where from_id=#{hailFellow.fromCustomer.id} and to_id=#{hailFellow.toCustomer.id}")
    void removeHailFellow(@Param("hailFellow") HailFellow hailFellow);

    @Update("update tb_hail_fellow set hf_remarks=#{hailFellow.remarks} " +
            "where from_id=#{hailFellow.fromCustomer.id} and to_id=#{hailFellow.toCustomer.id}")
    void editHailFellow(@Param("hailFellow") HailFellow hailFellow);

    @Results({
            @Result(property = "id",column = "hf_id",id = true),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "remarks",column = "hf_remarks")
    })
    @Select("select * from tb_hail_fellow where from_id=#{hailFellow.fromCustomer.id}")
    List<HailFellow> findHailFellowByCondition(@Param("hailFellow") HailFellow hailFellow);
}
