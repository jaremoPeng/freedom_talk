package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.HailFellow;
import com.jaremo.freedom_talk.customer.service.HailFellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 好友类controller层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 2:14
 */
@Controller
public class HailFellowController {

    @Autowired
    private HailFellowService hailFellowService;

    @RequestMapping("/lendHf.do")
    public void lendHf(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("a");
        Customer toCustomer = new Customer();
        toCustomer.setId("c");

        HailFellow hailFellow = new HailFellow();
        hailFellow.setToCustomer(toCustomer);
        hailFellow.setFromCustomer(fromCustomer);

        hailFellowService.insertHailFellow(hailFellow);
    }

    @RequestMapping("/deleteHf.do")
    public void delHf(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("c");
        Customer toCustomer = new Customer();
        toCustomer.setId("a");

        HailFellow hailFellow = new HailFellow();
        hailFellow.setToCustomer(toCustomer);
        hailFellow.setFromCustomer(fromCustomer);

        hailFellowService.deleteHailFellow(hailFellow);
    }

    @RequestMapping("/queryHf.do")
    public void queryHf(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("a");

        HailFellow hailFellow = new HailFellow();
        hailFellow.setFromCustomer(fromCustomer);

        List<HailFellow> hailFellows = hailFellowService.selectHailFellowByCondition(hailFellow);
        System.out.println(hailFellows);
    }
}
