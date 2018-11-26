package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.domain.ViewPointReply;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.customer.service.ViewPointReplyService;
import com.jaremo.freedom_talk.customer.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @描述: 观点回复类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 4:29
 */
@Controller
public class ViewPointReplyController {

    @Autowired
    private ViewPointReplyService viewPointReplyService;

    @Autowired
    private ViewPointService viewPointService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/lendvpr.do",method = RequestMethod.POST)
    @ResponseBody
    public void lendViewPointReply(String fromid,String toid,Integer vpid,ViewPointReply viewPointReply){
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setId(vpid);

        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

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


    @RequestMapping("/gotoVpR.do")
    public String gotoVp(Integer vpid, String fromid, String toid, ModelMap modelMap){
        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setId(vpid);

        List<ViewPoint> viewPointList = viewPointService.selectAllByCondition(viewPoint);

        Customer customer = new Customer();
        customer.setId(fromid);

        List<Customer> customers = customerService.selectAllByCondition(customer);

        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        List<Customer> customerList = customerService.selectAllByCondition(toCustomer);

        modelMap.addAttribute("viewPoint",viewPointList.get(0));
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("toCustoemr",customerList.get(0));
        return "view_point_reply";
    }
}
