package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.domain.UnLeaveWord;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import com.jaremo.freedom_talk.customer.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private CustomerService customerService;

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

    @RequestMapping(value = "/editlwIsStart.do",method = RequestMethod.POST)
    @ResponseBody
    public String editLeaveWordIsStart(String type,String cus_id){
        LeaveWord leaveWord = new LeaveWord();
        Customer from = new Customer();
        from.setId("gfrz");
        Customer to = new Customer();
        to.setId(cus_id);

        leaveWord.setFromCustomer(from);
        leaveWord.setToCustomer(to);

        if(type.equals("close")){
            leaveWord.setIsStart(0);
        }
        if(type.equals("open")){
            leaveWord.setIsStart(1);
        }

        leaveWordService.updateLeaveWord(leaveWord);
        return "";
    }

    @RequestMapping(value = "/editlwIsDelete.do",method = RequestMethod.POST)
    @ResponseBody
    public String editlwIsDelete(String fromid,String toid,Integer lwid){
        LeaveWord leaveWord = new LeaveWord();
        Customer from = new Customer();
        from.setId(fromid);
        Customer to = new Customer();
        to.setId(toid);

        leaveWord.setToCustomer(to);
        leaveWord.setFromCustomer(from);
        leaveWord.setId(lwid);
        leaveWord.setIsDelete(0);

        leaveWordService.updateLeaveWord(leaveWord);

        LeaveWordReply leaveWordReply = new LeaveWordReply();
        leaveWordReply.setLeaveWord(leaveWord);
        leaveWordReply.setIsDelete(0);

        leaveWordReplyService.deleteLeaveWordReply(leaveWordReply);
        return "";
    }

    @RequestMapping(value = "/addUnLw.do",method = RequestMethod.POST)
    @ResponseBody
    public String editlwIsDelete(String fromid,String toid){
        UnLeaveWord unLeaveWord = new UnLeaveWord();
        Customer from = new Customer();
        from.setId(fromid);
        Customer to = new Customer();
        to.setId(toid);

        unLeaveWord.setFromCustomer(from);
        unLeaveWord.setToCustomer(to);
        leaveWordService.insertUnLw(unLeaveWord);
        return "";
    }

    @RequestMapping(value = "/gotoLeaveWorld.do")
    public String gotoEditQue(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);

        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setToCustomer(tempCustomer);
        leaveWord.setIsDelete(1);

        List<LeaveWord> leaveWords = leaveWordService.selectLwByCondition(leaveWord);
        LeaveWord temp = null;
        if(leaveWord!=null && leaveWords.size()!=0){
            for (LeaveWord lw:leaveWords){
                if(lw.getFromCustomer()==null){ // 去出官方认证的记录
                    modelMap.addAttribute("isStart",lw.getIsStart()); // 是否开启留言板
                    temp = lw;
                }
            }
        }
        leaveWords.remove(temp);

        UnLeaveWord unLeaveWord = new UnLeaveWord();
        unLeaveWord.setFromCustomer(tempCustomer);
        List<UnLeaveWord> unLeaveWordList = leaveWordService.selectUnLwByFromCustomer(unLeaveWord);
        // 根据时间排序(根据时间倒序)
        modelMap.addAttribute("leaveWords",leaveWords); // 留言
        modelMap.addAttribute("unLeaveWordList",unLeaveWordList); // 禁止留言的用户列表
        modelMap.addAttribute("now_customer",customers.get(0)); // 当前用户
        return "leave_word";
    }
}
