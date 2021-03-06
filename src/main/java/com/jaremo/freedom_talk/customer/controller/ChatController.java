package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Chat;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/lendChat.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendChat(String fromid,String toid,Chat chat){
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        chat.setFromCustomer(fromCustomer);
        chat.setToCustomer(toCustomer);

        boolean result = chatService.insertChat(chat);
        if(result){
            return "";
        }
        return "failed";
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
