package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @描述: 客户类的dao层
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 7:08
 */
@Repository
public interface CustomerDao {

    @Insert("insert into tb_customer(cus_id,cus_loginname,cus_password,cus_email,question_id,cus_answer) "+
    "values (#{customer.id},#{customer.loginName},#{customer.password},#{customer.email},#{customer.question.id},#{customer.answer})")
    void addCustomer(@Param("customer") Customer customer);
}
