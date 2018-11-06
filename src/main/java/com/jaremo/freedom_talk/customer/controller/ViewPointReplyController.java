package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.domain.ViewPointReply;
import com.jaremo.freedom_talk.customer.service.ViewPointReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 观点回复类的
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 4:29
 */
@Controller
public class ViewPointReplyController {

    @Autowired
    private ViewPointReplyService viewPointReplyService;

    @RequestMapping("/lendvpr.do")
    public void lendViewPointReply(){
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setId(1);

        Customer fromCustomer = new Customer();
        fromCustomer.setId("b");
        Customer toCustomer = new Customer();
        toCustomer.setId("c");

        ViewPointReply viewPointReply = new ViewPointReply();
        viewPointReply.setContent("谁说不是呢?");
        viewPointReply.setFromCustomer(fromCustomer);
        viewPointReply.setToCustomer(toCustomer);
        viewPointReply.setViewPoint(viewPoint);

        int i = viewPointReplyService.insertViewPointReply(viewPointReply);
        if(i==1){
            System.out.println("添加成功");
        }
    }

    @RequestMapping("/queryvpr.do")
    public void queryViewPointReply(){
        ViewPointReply viewPointReply = new ViewPointReply();
        viewPointReply.setId(1);

        List<ViewPointReply> viewPointReplies = viewPointReplyService.selectAllByCondition(viewPointReply);
        System.out.println(viewPointReplies);
    }

    @RequestMapping("/deletevpr.do")
    public void delViewPointReply(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("b");

        ViewPointReply viewPointReply = new ViewPointReply();
        viewPointReply.setId(1);
        viewPointReply.setFromCustomer(fromCustomer);

        viewPointReplyService.deleteViewPointReply(viewPointReply);
    }
}
