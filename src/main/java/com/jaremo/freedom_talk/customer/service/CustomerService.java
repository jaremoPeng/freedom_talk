package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.background.domain.Question;
import com.jaremo.freedom_talk.customer.domain.Customer;

import java.util.List;

/**
 * @描述: 客户服务层
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 7:31
 */
public interface CustomerService {

    /**
     * 功能描述 添加客户
     * @author pyj
     * @date 2018/10/30 0030
     * @param customer
     * @return void
     */
    void insertCustomer(Customer customer , Integer questionId);

    /**
     * 功能描述 根据客户的登录名来查询客户
     * @author pyj
     * @date 2018/10/31 0031
     * @param loginName
     * @return
     */
    Customer selectCustomerByLoginName(String loginName);

    /**
     * 功能描述 修改用户信息
     * @author pyj
     * @date 2018/10/31 0031
     * @param customer
     * @return void
     */
    void updateCustomer(Customer customer);

    /**
     * 功能描述 根据条件查询客户
     * @author pyj
     * @date 2018/11/15 0015
     * @param customer
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.Customer>
     */
    List<Customer> selectAllByCondition(Customer customer);

    /**
     * 功能描述 获取所有的验证问题
     * @author pyj
     * @date 2018/11/21 0021
     * @param
     * @return java.util.List<com.jaremo.freedom_talk.background.domain.Question>
     */
    List<Question> selectAllQuestion();
}
