package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Follow;
import com.jaremo.freedom_talk.customer.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 关注类的controller层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 2:53
 */
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @RequestMapping("/lendFollow.do")
    public void lendFollow(){
        Customer customer = new Customer();
        customer.setId("c");

        Customer moderator = new Customer();
        moderator.setId("a");

        Follow follow = new Follow();
        follow.setCustomer(customer);
        follow.setModerator(moderator);

        followService.insertFollow(follow);
    }

    @RequestMapping("/delFollow.do")
    public void delFollow(){
        Customer customer = new Customer();
        customer.setId("c");

        Customer moderator = new Customer();
        moderator.setId("a");

        Follow follow = new Follow();
        follow.setCustomer(customer);
        follow.setModerator(moderator);

        followService.deleteFollow(follow);
    }

    @RequestMapping("/queryFollow.do")
    public void queryFollow(){
        Customer customer = new Customer();
        customer.setId("c");

        Follow follow = new Follow();
        follow.setCustomer(customer);

        List<Follow> followList = followService.selectFollowByCondition(follow);
        System.out.println(followList);
    }
}
