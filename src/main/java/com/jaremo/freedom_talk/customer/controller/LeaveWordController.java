package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述: 留言类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 9:22
 */
@Controller
public class LeaveWordController {

    @Autowired
    private LeaveWordService leaveWordService;

    @RequestMapping("/lendlw.do")
    public void lendLeaveWord(){
        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setContent("你还好吗?");
        Customer from = new Customer();
        from.setId("123");
        Customer to = new Customer();
        to.setId("456");

        leaveWord.setFromCustomer(from);
        leaveWord.setToCustomer(to);

        leaveWordService.insertLeaveWord(leaveWord);
    }
}
