package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Message;
import com.jaremo.freedom_talk.customer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 消息类controller层
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 1:26
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/deleteMsg.do")
    public void delMsg(){
        Message message = new Message();
        message.setId(1);
        message.setIsDelete(0);

        messageService.deleteMsg(message);
    }

    @RequestMapping("/queryMsg.do")
    public void queryMsg(){
        Customer customer = new Customer();
        customer.setId("a");

        Message message = new Message();
        message.setCustomer(customer);

        List<Message> messages = messageService.selectMsgByCondition(message);
        System.out.println(messages);
    }
}
