package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Collect;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void delCollect(){
        Note note = new Note();
        note.setId(2);

        Customer customer = new Customer();
        customer.setId("C");

        Collect collect = new Collect();
        collect.setCustomer(customer);
        collect.setNote(note);

        collectService.deleteCollect(collect);
    }

    @RequestMapping("/queryCollect.do")
    public void queryCollect(){
        Customer customer = new Customer();
        customer.setId("C");

        Collect collect = new Collect();
        collect.setCustomer(customer);
        collect.setIsDelete(1);

        List<Collect> collectList = collectService.selectAllByCondition(collect);
        System.out.println(collectList);
    }
}
