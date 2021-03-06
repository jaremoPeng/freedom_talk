package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @描述: 留言回复类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--上午 9:04
 */
@Controller
public class LeaveWordReplyController {

    @Autowired
    private LeaveWordReplyService leaveWordReplyService;

    @RequestMapping(value = "/lend_lwr.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendLeaveWordReply(Integer lwid,String fromid,String toid,String content){

        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setReplyContent(content);

        LeaveWord leaveWord = new LeaveWord(); // 回复哪条留言
        leaveWord.setId(lwid);

        Customer fromCustomer = new Customer();
        fromCustomer.setId(fromid);
        Customer toCustomer = new Customer();
        toCustomer.setId(toid);

        leaveWordReply.setLeaveWord(leaveWord);
        leaveWordReply.setFromCustomer(fromCustomer);
        leaveWordReply.setToCustomer(toCustomer);

        boolean result = leaveWordReplyService.insertLeaveWordReply(leaveWordReply);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/delete_lwr.do",method = RequestMethod.POST)
    @ResponseBody
    public String deleteLeaveWordReply(Integer lwrid){
        // 删除留言回复
        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setId(lwrid);
        leaveWordReply.setIsDelete(0);

        boolean result = leaveWordReplyService.deleteLeaveWordReply(leaveWordReply);
        if(result){
            return "";
        }
        return "failed";
    }
}
