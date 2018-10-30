package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.utils.RandomUtil;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.mail.Apply;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @描述: 客户控制层
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 7:37
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisUtil redisUtil;

    private Logger log = Logger.getLogger(CustomerController.class);

    @RequestMapping(value = "/regist.do")
    public void regCustomer(){
        Customer customer = new Customer();
        customer.setLoginName("jaremo");
        customer.setPassword("123456");
        customer.setEmail("744273057@qq.com");
        customer.setAnswer("jet"); // 设置登录验证问题答案

//        String inputCode = "123456"; // 模拟客户输入邮箱验证码

//        String trueCode = (String) redisUtil.get("emailCode"); // 获取redis中邮箱验证码
//        if(trueCode != null && trueCode.equals(inputCode)){
            customerService.insertCustomer(customer,2); // 这里选择验证问题 写死
//        }else{
//            log.debug("验证码失效,或者不存在");
//        }
    }

    @RequestMapping("/sendEmail.do")
    public void verifyEmail(){
        String emailCode = RandomUtil.getRandom(6); // 生成邮箱验证码
        ArrayList<String> toList = new ArrayList<>();
        toList.add("744273057@qq.com");
        try {
            Apply.sendEmail("jaremo@163.com",toList,"jj123456","163"
                    ,"来自自由说论坛的验证邮件: ","你当前验证码为: "+emailCode+" 请在两分钟之内验证!!!!");
        } catch (IOException e) {
            log.debug("发送邮件验证失败: "+e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            log.debug("发送邮件验证失败: "+e.getMessage());
            e.printStackTrace();
        }

        redisUtil.set("emailCode",emailCode); // 将邮箱验证码存放到redis中 以邮箱作键
        redisUtil.expire("emailCode",120); // 设置过期时间
    }
}
