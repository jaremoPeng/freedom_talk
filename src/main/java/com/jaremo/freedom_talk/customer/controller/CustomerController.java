package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.utils.RandomUtil;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.mail.Apply;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    /**
     * 功能描述 修改用户信息
     * @author pyj
     * @date 2018/10/31 0031
     * @param
     * @return void
     */
    @RequestMapping("/edit.do")
    public void editCustomer(){
        // 个性签名, 昵称, 性别, 出生年月
        // 选择出生年份自动确定年龄

        Customer customer = new Customer();
        customer.setId("da7dd3ba32eb430d8da4f6bbca63fb06");
        customer.setSuggest("我是根据修改的准值!!!");
        customer.setName("new name");
        customer.setSex("女");
        customer.setBirthdate("2002-03-28");

        customerService.updateCustomer(customer);
    }

    /**
     * 功能描述 用户登录
     *
     * @param
     * @return
     * @author pyj
     * @date 2018/10/31 0031
     */
    @RequestMapping("/login.do")
    public void lgnCustomer() {

        Customer customer = new Customer();
        customer.setLoginName("jaremo");
        customer.setPassword("123456");
        customer.setAnswer("jetd");

        Customer checkCus = customerService.selectCustomerByLoginName(customer.getLoginName());

        if(checkCus!=null & 2 == checkCus.getQuestion().getId()){ // 判断不为空的情况下,还要判断验证问题是否选者正确
            if(checkCus.getAnswer().equals(customer.getAnswer())){ // 验证问题的答案是否正确
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(customer.getLoginName(), customer.getPassword());

                subject.login(token);

                if (subject.isAuthenticated()) {
                    System.out.println("sucsses");
                } else {
                    System.out.println("failed");
                }
            }else{
                System.out.println("验证问题的答案输入错误");
            }
        }
    }

    /**
     * 功能描述 注册用户
     *
     * @param
     * @return void
     * @author pyj
     * @date 2018/10/31 0031
     */
    @RequestMapping(value = "/regist.do")
    public void regCustomer() {
        Customer customer = new Customer();
        customer.setLoginName("jaremo");
        customer.setPassword("123456");
        customer.setEmail("744273057@qq.com");
        customer.setAnswer("jet"); // 设置登录验证问题答案

//        String inputCode = "123456"; // 模拟客户输入邮箱验证码

//        String trueCode = (String) redisUtil.get("emailCode"); // 获取redis中邮箱验证码
//        if(trueCode != null && trueCode.equals(inputCode)){
        customerService.insertCustomer(customer, 2); // 这里选择验证问题 写死
//        }else{
//            log.debug("验证码失效,或者不存在");
//        }
    }

    /**
     * 功能描述 给用户发送邮件
     *
     * @param
     * @return void
     * @author pyj
     * @date 2018/10/31 0031
     */
    @RequestMapping("/sendEmail.do")
    public void verifyEmail() {
        String emailCode = RandomUtil.getRandom(6); // 生成邮箱验证码
        ArrayList<String> toList = new ArrayList<>();
        toList.add("744273057@qq.com");
        try {
            Apply.sendEmail("jaremo@163.com", toList, "jj123456", "163"
                    , "来自自由说论坛的验证邮件: ", "你当前验证码为: " + emailCode + " 请在两分钟之内验证!!!!");
        } catch (IOException e) {
            log.debug("发送邮件验证失败: " + e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            log.debug("发送邮件验证失败: " + e.getMessage());
            e.printStackTrace();
        }
        redisUtil.set("emailCode", emailCode); // 将邮箱验证码存放到redis中 以邮箱作键
        redisUtil.expire("emailCode", 120); // 设置过期时间
    }
}
