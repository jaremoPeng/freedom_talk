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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private static String trueCode;

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
    public String lgnCustomer(Customer customer,Integer question_id,String logintype,ModelMap modelMap) {
        List<Customer> customers = customerService.selectAllByCondition(customer);

        if(customers!=null && customers.size()==1 & question_id == customers.get(0).getQuestion().getId()){ // 判断不为空的情况下,还要判断验证问题是否选者正确
            if(customers.get(0).getAnswer().equals(customer.getAnswer())){ // 验证问题的答案是否正确
                if(customers.get(0).getIsUnuse()!=0){ // 判读用户是否被禁用
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(customers.get(0).getLoginName(), customer.getPassword());

                    subject.login(token);

                    if (subject.isAuthenticated()) {
                        System.out.println("登录成功");
                        modelMap.addAttribute("now_customer",customers.get(0));
                        if(customers.get(0).getType().equals("0")){
                            return "bg_index";
                        }
                        return "index";
                    } else {
                        System.out.println("登录失败");
                    }
                }else{
                    System.out.println("该用户已被禁用");
                }
            }else{
                System.out.println("验证问题的答案输入错误");
            }
        }else{
            System.out.println("用户不存在");
        }
        return "login";
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
    public String regCustomer(Customer customer,Integer question_id,String inputCode) {

//        String trueCode = (String) redisUtil.get("emailCode"); // 获取redis中邮箱验证码
        if (trueCode != null && trueCode.equals(inputCode)){
            customerService.insertCustomer(customer, question_id); // 这里选择验证问题 写死
            return "login";
        }else{
            log.debug("验证码失效,或者不存在");
            return "regist";
        }
    }

    /**
     * 功能描述 给用户发送邮件
     *
     * @param
     * @return void
     * @author pyj
     * @date 2018/10/31 0031
     */
    @RequestMapping(value = "/sendEmail.do",method = RequestMethod.POST)
    public void verifyEmail(String email) {

        System.out.println("邮箱: "+email);
        trueCode = RandomUtil.getRandom(6); // 生成邮箱验证码
        System.out.println("邮箱验证码为: " + trueCode);
        ArrayList<String> toList = new ArrayList<>();
        toList.add(email);
        try {
            Apply.sendEmail("jaremo@163.com", toList, "jj123456", "163"
                    , "来自自由说论坛的验证邮件: ", "你当前验证码为: <a href='#'>" + trueCode + "</a> 请在两分钟之内验证!!!!");
        } catch (IOException e) {
            log.debug("发送邮件验证失败: " + e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            log.debug("发送邮件验证失败: " + e.getMessage());
            e.printStackTrace();
        }
//        redisUtil.set("emailCode", emailCode); // 将邮箱验证码存放到redis中 以邮箱作键
//        redisUtil.expire("emailCode", 120); // 设置过期时间
    }

    @RequestMapping("/getAllQue.do")
    public String getVerifyQue(String type,ModelMap modelMap) { //由于注册和登录都需要获取所有的问题 type 为1 就是登录界面,为2 注册界面
        modelMap.addAttribute("questionList",customerService.selectAllQuestion());
        if(type.equals("1")){
            return "login";
        }
        if(type.equals("2")){
            return "regist";
        }
        return null;
    }

    @RequestMapping("/exit.do")
    public String exit(ModelMap modelMap) { // 退出action
        modelMap.remove("now_customer");
        return "index";
    }

    @RequestMapping(value = "/verifyLoginName.do",method = RequestMethod.POST)
    @ResponseBody
    public String verifyloginName(String loginName) { // 验证用户名是否已经注册
        Customer customer = customerService.selectCustomerByLoginName(loginName);
        if(customer!=null){
            System.out.println("用户名已注册");
            return "用户名已注册";
        }
        return "";
    }

    @RequestMapping(value = "/verifyMail.do",method = RequestMethod.POST)
    @ResponseBody
    public String verifyMail(String email) { // 验证邮箱是否已经注册
        Customer tempCustomer = new Customer();
        tempCustomer.setEmail(email);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        if(customers!=null && customers.size()!=0){
            System.out.println("邮箱已注册");
            return "邮箱已注册";
        }
        return "";
    }
}
