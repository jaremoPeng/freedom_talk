package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述: 留言回复类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--上午 9:04
 */
@Controller
public class LeaveWordReplyController {

    @Autowired
    private LeaveWordReplyService leaveWordReplyService;

    @RequestMapping("/lend_lwr.do")
    public void lendLeaveWordReply(){

        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setReplyContent("你禁我言干啥?");

        LeaveWord leaveWord = new LeaveWord(); // 回复哪条留言
        leaveWord.setId(3);

        Customer fromCustomer = new Customer();
        fromCustomer.setId("b");
        Customer toCustomer = new Customer();
        toCustomer.setId("a");

        leaveWordReply.setLeaveWord(leaveWord);
        leaveWordReply.setFromCustomer(fromCustomer);
        leaveWordReply.setToCustomer(toCustomer);

        leaveWordReplyService.insertLeaveWordReply(leaveWordReply);

    }

    @RequestMapping("/delete_lwr.do")
    public void deleteLeaveWordReply(){
        // 删除留言回复
        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setId(1);
        leaveWordReply.setIsDelete(0);

        leaveWordReplyService.deleteLeaveWordReply(leaveWordReply);
    }
}
