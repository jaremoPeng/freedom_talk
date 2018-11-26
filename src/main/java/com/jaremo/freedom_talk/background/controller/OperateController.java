package com.jaremo.freedom_talk.background.controller;

import com.google.gson.Gson;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @描述: 后台操作控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 5:15
 */
@Controller
public class OperateController {

    @Autowired
    private CustomerService customerService;

    private static Gson gson = new Gson();

    @RequestMapping("/searchCus.do")
    @ResponseBody
    public String searchCus(String cuskw){
        Customer customer = new Customer();
        customer.setLoginName(cuskw);

        List<Customer> customers = customerService.selectAllByCondition(customer);
        if(customers!=null && customers.size()>0){
            String jsonStr = gson.toJson(customers.get(0));
            return jsonStr;
        }
        return "";
    }

    @RequestMapping("/editCusUnuse.do")
    @ResponseBody
    public String editCusUnuse(String cusid){
        Customer customer = new Customer();
        customer.setId(cusid);
        customer.setIsUnuse(0);

        customerService.updateCustomer(customer);
        return "";
    }

    @RequestMapping("/editCusBm.do")
    @ResponseBody
    public String editCusBm(String cusid){
        Customer customer = new Customer();
        customer.setId(cusid);
        customer.setType(2);
        customer.setIsBm(1);

        customerService.updateCustomer(customer);
        return "";
    }
//
//    @RequestMapping("/gotoBgCategoryList.do")
//    public String gotoBgCategoryList(){
//        return "bg_category_list";
//    }
//
//    @RequestMapping("/gotoBgACAdd.do")
//    public String gotoBgACAdd(){
//        return "bg_ac_add";
//    }
//
//    @RequestMapping("/gotoBgACList.do")
//    public String gotoBgACList(){
//        return "bg_ac_list";
//    }
//
//    @RequestMapping("/gotoBgRoleManage.do")
//    public String gotoBgRoleManage(){
//        return "bg_role_manage";
//    }
//
//    @RequestMapping("/gotoBgPermManage.do")
//    public String gotoBgPermManage(){
//        return "bg_perm_manage";
//    }
}