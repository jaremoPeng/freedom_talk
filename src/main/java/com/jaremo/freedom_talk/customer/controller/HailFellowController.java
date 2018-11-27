package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Chat;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.HailFellow;
import com.jaremo.freedom_talk.customer.service.ChatService;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.customer.service.HailFellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/lendHf.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendHf(String fromid,String toid){
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        HailFellow hailFellow = new HailFellow();
        hailFellow.setToCustomer(toCustomer);
        hailFellow.setFromCustomer(fromCustomer);

        int result = hailFellowService.insertHailFellow(hailFellow);
        if(result==1){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/editHf.do",method = RequestMethod.POST)
    @ResponseBody
    public String editHf(String fromid,String toid,String remarks){
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        HailFellow hailFellow = new HailFellow();
        hailFellow.setToCustomer(toCustomer);
        hailFellow.setFromCustomer(fromCustomer);
        hailFellow.setRemarks(remarks);

        boolean result = hailFellowService.updateHailFellow(hailFellow);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/deleteHf.do",method = RequestMethod.POST)
    @ResponseBody
    public String delHf(String fromid,String toid){
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        HailFellow hailFellow = new HailFellow();
        hailFellow.setToCustomer(toCustomer);
        hailFellow.setFromCustomer(fromCustomer);

        boolean result = hailFellowService.deleteHailFellow(hailFellow);

        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/gotoHailFellow.do")
    public String gotoHailFellow(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);

        HailFellow hailFellow = new HailFellow();
        hailFellow.setFromCustomer(tempCustomer);

        List<HailFellow> hailFellows = hailFellowService.selectHailFellowByCondition(hailFellow);

        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("hailFellows",hailFellows);
        return "hail_fellow";
    }

    @RequestMapping(value = "/gotoHfchat.do")
    public String gotoHfchat(String fromid,String toid,ModelMap modelMap) { // 做一个中转
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);

        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        Chat chat = new Chat();
        chat.setFromCustomer(fromCustomer);
        chat.setToCustomer(toCustomer);

        List<Chat> chats = chatService.selectChatByCondition(chat);
        List<Customer> customers = customerService.selectAllByCondition(fromCustomer);
        List<Customer> toCustomers = customerService.selectAllByCondition(toCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("toCustomer",toCustomers.get(0));
        modelMap.addAttribute("chats",chats);
        return "hf_chat";
    }

    @RequestMapping(value = "/gotoHfremarks.do")
    public String gotoHfremarks(String fromid,String toid,ModelMap modelMap) { // 做一个中转
        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);

        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        List<Customer> customers = customerService.selectAllByCondition(fromCustomer);
        List<Customer> toCustomers = customerService.selectAllByCondition(toCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("toCustomer",toCustomers.get(0));
        return "hf_remarks";
    }

    @RequestMapping(value = "/gotoHailFellowAdd.do")
    public String gotoHailFellowAdd(String fromid,String toid,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(toid);

        Customer customer = new Customer();
        customer.setId(fromid);

        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        List<Customer> fCustomers = customerService.selectAllByCondition(customer);
        modelMap.addAttribute("toCustomer",customers.get(0));
        modelMap.addAttribute("now_customer",fCustomers.get(0));
        return "hf_addpage";
    }
}
