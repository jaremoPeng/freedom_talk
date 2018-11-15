package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 用户管理控制层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 9:19
 */
@Controller
public class CustomerManageController {

    @Autowired
    public CustomerService customerService;

    @RequestMapping("/unuseCus.do")
    public void unUseCustomer(){
        Customer customer = new Customer();
        customer.setId("a");
        customer.setIsUnuse(0);

        customerService.updateCustomer(customer);
    }

    @RequestMapping("/operBm.do")
    public void operationBm(){
        Customer customer = new Customer();
        customer.setId("c");
        customer.setIsBm(1);
        customer.setType(2);
        customerService.updateCustomer(customer);
    }

    @RequestMapping("/checkCus.do")
    public void checkCus(){
        Customer customer = new Customer();
        customer.setIsBm(1);
        customer.setType(2);
        List<Customer> customers = customerService.selectAllByCondition(customer);
        System.out.println(customers);
    }
}
