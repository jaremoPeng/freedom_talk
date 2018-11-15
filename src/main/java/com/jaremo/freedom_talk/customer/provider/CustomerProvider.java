package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.Customer;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: sql的动态拼接类
 * @Author: pyj
 * @DateTime: 2018/10/31 0031--下午 3:25
 */
public class CustomerProvider {

    // 客户的修改
    public String editCustomer(Map map){
        Customer customer = (Customer) map.get("customer");
        SQL sql =new SQL();
        sql.UPDATE("tb_customer");
        if(customer.getPassword()!=null){
            sql.SET("cus_password = #{customer.password}");
        }
        if(customer.getImg()!=null){
            sql.SET("cus_img = #{customer.img}");
        }
        if(customer.getSuggest()!=null){
            sql.SET("cus_suggest = #{customer.suggest}");
        }
        if(customer.getName()!=null){
            sql.SET("cus_name = #{customer.name}");
        }
        if(customer.getSex()!=null){
            sql.SET("cus_sex = #{customer.sex}");
        }
        if(customer.getBirthdate()!=null){
            sql.SET("cus_birthdate = #{customer.birthdate}");
        }
        if(customer.getIsUnuse()!=null){
            sql.SET("isUnuse = #{customer.isUnuse}");
        }
        if(customer.getIsBm()!=null){
            sql.SET("isBm = #{customer.isBm}");
        }
        if(customer.getQuestion()!=null){
            sql.SET("question_id = #{customer.question.id}");
        }
        if(customer.getAnswer()!=null){
            sql.SET("cus_answer = #{customer.answer}");
        }
        if(customer.getAge()!=null){
            sql.SET("cus_age = #{customer.age}");
        }
        if(customer.getType()!=null){
            sql.SET("cus_type = #{customer.type}");
        }
        sql.WHERE("cus_id=#{customer.id}");
        return sql.toString();
    }

    public String findCustomerByCondition(Map map){
        Customer customer = (Customer) map.get("customer");
        SQL sql =new SQL();
        sql.SELECT("*").FROM("tb_customer");
        if(customer.getIsUnuse()!=null){
            sql.WHERE("isUnuse = #{customer.isUnuse}");
        }
        if(customer.getIsBm()!=null){
            sql.WHERE("isBm = #{customer.isBm}");
        }
        if(customer.getType()!=null){
            sql.WHERE("cus_type = #{customer.type}");
        }
        if(customer.getId()!=null){
            sql.WHERE("cus_id = #{customer.id}");
        }
        if(customer.getEmail()!=null){
            sql.WHERE("cus_email = #{customer.email}");
        }
        if(customer.getLoginName()!=null){
            sql.WHERE("cus_loginname = #{customer.loginName}");
        }
        return sql.toString();
    }
}
