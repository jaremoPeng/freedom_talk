package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Chat;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 聊天类controller层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 5:17
 */
@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping("/lendChat.do")
    public void lendChat(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("a");
        Customer toCustomer = new Customer();
        toCustomer.setId("c");

        Chat chat = new Chat();
        chat.setFromCustomer(fromCustomer);
        chat.setToCustomer(toCustomer);
        chat.setContent("hello , i'm a!");

        chatService.insertChat(chat);

    }

    @RequestMapping("/delChat.do")
    public void delChat(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("a");
        Customer toCustomer = new Customer();
        toCustomer.setId("c");

        Chat chat = new Chat();
        chat.setFromCustomer(fromCustomer);
        chat.setToCustomer(toCustomer);

        chatService.deleteChat(chat);
    }

    @RequestMapping("/queryChat.do")
    public void queryChat(){
        Customer fromCustomer = new Customer();
        fromCustomer.setId("a");
        Customer toCustomer = new Customer();
        toCustomer.setId("c");

        Chat chat = new Chat();
        chat.setFromCustomer(fromCustomer);
        chat.setToCustomer(toCustomer);

        List<Chat> chats = chatService.selectChatByCondition(chat);

        for (Chat tempChat:chats){
            System.out.println(tempChat.getFromCustomer().getId()+" 对 "+tempChat.getToCustomer().getId()+" 说: "+tempChat.getContent());
        }
    }
}
