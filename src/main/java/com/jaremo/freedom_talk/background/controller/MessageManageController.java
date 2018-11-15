package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Message;
import com.jaremo.freedom_talk.customer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述: 消息管理类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/15 0015--上午 8:58
 */
@Controller
public class MessageManageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/lendMsgm.do")
    public void lendMsgm(){
        Customer customer = new Customer();
        customer.setId("a");

        Message message = new Message();
        message.setCustomer(customer);
        message.setContent("恭喜你成为自由说论坛的一员");

        messageService.insertMsg(message);
    }


}
