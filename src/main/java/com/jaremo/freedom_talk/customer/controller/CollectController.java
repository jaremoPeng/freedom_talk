package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Collect;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.CollectService;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @描述: 收藏类的controller层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:51
 */
@Controller
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/lendCollect.do")
    public void lendCollect(){
        Note note = new Note();
        note.setId(2);

        Customer customer = new Customer();
        customer.setId("C");

        Collect collect = new Collect();
        collect.setCustomer(customer);
        collect.setNote(note);

        collectService.insertCollect(collect);
    }

    @RequestMapping("/delCollect.do")
    @ResponseBody
    public String delCollect(String cusid,String noteid){
        Customer customer = new Customer();
        customer.setId(cusid);

        Note note = new Note();
        note.setId(Integer.parseInt(noteid));
        Collect collect = new Collect();
        collect.setCustomer(customer);
        collect.setNote(note);

        collectService.deleteCollect(collect);

        return "";
    }

    @RequestMapping("/queryCollect.do")
    public void queryCollect(){
        Customer customer = new Customer();
        customer.setId("C");

    }

    @RequestMapping(value = "/gotoCollect.do")
    public String gotoCollect(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);

        Collect collect = new Collect();
        collect.setCustomer(tempCustomer);
        collect.setIsDelete(1);

        List<Collect> collectList = collectService.selectAllByCondition(collect);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("collectList",collectList);
        return "collect";
    }
}
