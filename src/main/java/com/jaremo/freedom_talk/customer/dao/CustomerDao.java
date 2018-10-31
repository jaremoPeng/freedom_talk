package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.background.domain.Question;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.provider.CustomerProvider;
import org.apache.ibatis.annotations.*;
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

    @Results({
            @Result(id = true , column = "cus_id" , property = "id"),
            @Result(column = "cus_loginname" , property = "loginName"),
            @Result(column = "cus_password" , property = "password"),
            @Result(column = "cus_email" , property = "email"),
            @Result(column = "cus_img" , property = "img"),
            @Result(column = "cus_suggest" , property = "suggest"),
            @Result(column = "cus_name" , property = "name"),
            @Result(column = "cus_sex" , property = "sex"),
            @Result(column = "cus_birthdate" , property = "birthdate"),
            @Result(column = "isUnuse" , property = "isUnuse"),
            @Result(column = "isBm" , property = "isBm"),
            @Result(column = "question_id" , property = "question" , javaType = Question.class , one = @One(select = "com.jaremo.freedom_talk.background.dao.QuestionDao.findQuestionById")),
            @Result(column = "cus_answer" , property = "answer"),
            @Result(column = "cus_fans" , property = "fansNum"),
            @Result(column = "cus_follow" , property = "followNum"),
            @Result(column = "cus_age" , property = "age"),
            @Result(column = "cus_type" , property = "type")
    })
    @Select("select * from tb_customer where cus_loginname = #{loginName}")
    Customer findCustomerByLoginName(String loginName);

    @UpdateProvider(type = CustomerProvider.class,method = "editCustomer")
    void alterCustomer(@Param("customer") Customer customer);


}
