package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Message;
import com.jaremo.freedom_talk.customer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/editMsg.do",method = RequestMethod.POST)
    @ResponseBody
    public String delMsg(String cus_id){
        Customer customer = new Customer();
        customer.setId(cus_id);

        Message message = new Message();
        message.setIsRead(1);
        message.setCustomer(customer);

        boolean result = messageService.updateMsgState(message);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping("/queryMsg.do")
    public String queryMsg(String cus_id,ModelMap map){
        Customer customer = new Customer();
        customer.setId(cus_id);

        Message message = new Message();
        message.setCustomer(customer);
        message.setIsDelete(1);

        List<Message> messages = messageService.selectMsgByCondition(message);
        map.addAttribute("messages",messages);
        return "message";
    }

    @RequestMapping("/getUnreadMsg.do")
    @ResponseBody
    public int getUnreadMsg(String cus_id){
        Customer customer = new Customer();
        customer.setId(cus_id);

        Message message = new Message();
        message.setCustomer(customer);
        message.setIsDelete(1);

        List<Message> messages = messageService.selectMsgByCondition(message);

        int resultCount = 0;
        for (int i=0;i<messages.size();i++) {
            if(messages.get(i).getIsRead()==0){
                ++resultCount;
            }
        }
        return resultCount;
    }
}
