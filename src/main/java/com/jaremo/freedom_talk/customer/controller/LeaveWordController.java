package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import com.jaremo.freedom_talk.customer.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述: 留言类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 9:22
 */
@Controller
public class LeaveWordController {

    @Autowired
    private LeaveWordService leaveWordService;

    @Autowired
    private LeaveWordReplyService leaveWordReplyService;

    @RequestMapping("/lendlw.do")
    public void lendLeaveWord(){
        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setContent("b say to a?");
        Customer from = new Customer();
        from.setId("b");
        Customer to = new Customer();
        to.setId("a");

        leaveWord.setFromCustomer(from);
        leaveWord.setToCustomer(to);

        int i = leaveWordService.insertLeaveWord(leaveWord);
        System.out.println(i);
    }

    @RequestMapping("/querylw.do")
    public void queryLeaveWord(){
        Customer a = new Customer();
        a.setId("a");

        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setToCustomer(a);
        leaveWord.setIsDelete(1);

        Map<Integer,List<LeaveWordReply>> map = new HashMap<>(); // 留言对应的留言回复(以留言id作键,留言回复类作值)

        List<LeaveWord> leaveWords = leaveWordService.selectLwByCondition(leaveWord);
        if(leaveWord!=null && leaveWords.size()!=0){
            for (LeaveWord lw:leaveWords){
                LeaveWordReply leaveWordReply = new LeaveWordReply();
                leaveWordReply.setLeaveWord(lw);
                leaveWordReply.setIsDelete(1);

                List<LeaveWordReply> leaveWordReplies = leaveWordReplyService.selectLeaveWordReplyByCondition(leaveWordReply);
                map.put(lw.getId(),leaveWordReplies);
            }
        }

        System.out.println(map);
    }

    @RequestMapping("/deletelw.do")
    public void deleteLeaveWord(){
        // 删除留言
        // 清除该留言下的回复记录

        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setId(4);
        Customer c = new Customer();
        c.setId("c");
        Customer a = new Customer();
        a.setId("a");

        leaveWord.setFromCustomer(c);
        leaveWord.setToCustomer(a);
        leaveWord.setIsDelete(0);

        leaveWordService.updateLeaveWord(leaveWord);

        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setLeaveWord(leaveWord);
        leaveWordReply.setIsDelete(0);

        leaveWordReplyService.deleteLeaveWordReply(leaveWordReply);
    }
}
