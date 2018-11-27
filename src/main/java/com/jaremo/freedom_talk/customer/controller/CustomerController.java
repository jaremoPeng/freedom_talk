package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.background.domain.Announcement;
import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.domain.Question;
import com.jaremo.freedom_talk.background.service.AnnouncementService;
import com.jaremo.freedom_talk.background.service.CategoryService;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.customer.service.NoteService;
import com.jaremo.freedom_talk.utils.RandomUtil;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.UUIDPlusUtil;
import com.jaremo.freedom_talk.utils.mail.Apply;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

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
    @ResponseBody
    public void editCustomer(@RequestParam("file") MultipartFile mf,Customer customer){
        // 个性签名, 昵称, 性别, 出生年月
        // 选择出生年份自动确定年龄
        String dbPath = null;
        try{
            // 文件名
            String filename = new String(mf.getOriginalFilename().getBytes("utf-8"),"iso-8859-1");
            int result = filename.lastIndexOf(".");
            filename = "img_ft"+System.currentTimeMillis()+filename.substring(result);
            dbPath = "/img/"+filename;
            String savePath = "E:/ideacode/freedom_talk/src/main/webapp"; // Linux环境下路径需要修改
            mf.transferTo(new File(savePath+dbPath));
        }catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }

        customer.setImg(dbPath);
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
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String lgnCustomer(Customer customer,Integer question_id,String logintype,ModelMap modelMap) {
        List<Customer> customers = customerService.selectAllByCondition(customer);
        List<String> allErrors = new ArrayList<>();
        if(customers!=null && customers.size()==1 & question_id == customers.get(0).getQuestion().getId()){ // 判断不为空的情况下,还要判断验证问题是否选者正确
            if(customers.get(0).getAnswer().equals(customer.getAnswer())){ // 验证问题的答案是否正确
                if(customers.get(0).getIsUnuse()!=0){ // 判读用户是否被禁用
                    Subject subject = null;
                    try {
                        subject = SecurityUtils.getSubject();
                        UsernamePasswordToken token = new UsernamePasswordToken(customers.get(0).getLoginName(), customer.getPassword());

                        subject.login(token);
                        if (subject.isAuthenticated()) {
                            modelMap.addAttribute("now_customer",customers.get(0));
                            if(customers.get(0).getType()==0){
                                return "bg_index";
                            }
                            // 分类
                            Category category = new Category();
                            category.setIsDelete(1);
                            List<Category> categoryList = categoryService.selectAllByCondition(category);
                            modelMap.addAttribute("categoryList",categoryList);

                            // 公告
                            Announcement announcement = new Announcement();
                            announcement.setIsDelete(1);
                            List<Announcement> announcements = announcementService.selectAllByCondition(announcement);
                            modelMap.addAttribute("announcements",announcements);

                            // 热门版主
                            Customer hotcustomer = new Customer();
                            hotcustomer.setType(2);
                            hotcustomer.setIsBm(1);
                            hotcustomer.setIsUnuse(1);
                            List<Customer> hotCustomers = customerService.selectAllByCondition(hotcustomer); // 查询所有的版主,帖子浏览数和评论数,推选出最热门的版主
                            modelMap.addAttribute("customers",hotCustomers);

                            // 热帖(一周的时间,评选最优帖子 , 条件是以评论数,和浏览数 相加)
                            Note note = new Note();
                            note.setIsDelete(1);
                            List<Note> noteList = noteService.selectAllByCondition(note);
                            modelMap.addAttribute("noteList",noteList);

                            // 昨日热帖(统计昨天最火爆的帖子)
                            Note yestoday_note = new Note();
                            yestoday_note.setIsDelete(1);
                            List<Note> ytNoteList = noteService.selectAllByCondition(yestoday_note);
                            modelMap.addAttribute("ytNoteList",ytNoteList);

                            // 每日新帖(展示今天最新发布的帖子)
                            Note new_note = new Note();
                            new_note.setIsDelete(1);
                            List<Note> newNoteList = noteService.selectAllByCondition(new_note);
                            modelMap.addAttribute("newNoteList",newNoteList);
                            return "index";
                        } else {
                            allErrors.add("登录失败");
                        }
                    } catch (AuthenticationException e) {
                        allErrors.add("用户验证失败(可能原因有: 1.密码输入错误;2该用户未注册[如实在还有问题,请发至邮箱 jaremo@163.com])");
                    }
                }else{
                    allErrors.add("该用户已被禁用");
                }
            }else{
                allErrors.add("验证问题的答案输入错误");
            }
        }else{
            allErrors.add("用户不存在");
        }
        if(allErrors.size()!=0){
            modelMap.addAttribute("errors",allErrors);
            return "errors";
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
    @RequestMapping(value = "/regist.do",method = RequestMethod.POST)
    public String regCustomer(@Valid Customer customer , BindingResult errors, Integer question_id, String inputCode,ModelMap modelMap) {

        List<String> allErrors = new ArrayList<>();
//        String trueCode = (String) redisUtil.get("emailCode"); // 获取redis中邮箱验证码
        if (trueCode != null && trueCode.equals(inputCode)){
            if(errors.hasErrors()){
                List<FieldError> fieldErrors = errors.getFieldErrors();
                for (FieldError temp:fieldErrors) {
                    allErrors.add(temp.getDefaultMessage());
                }

                modelMap.addAttribute("errors",allErrors);
                return "errors";
            }
            customerService.insertCustomer(customer, question_id); // 这里选择验证问题 写死
            modelMap.addAttribute("questionList",customerService.selectAllQuestion());
            return "login";
        }else{
            errors.addError(new FieldError("customer","loginName","验证码失效,或者不存在"));
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError temp:fieldErrors) {
                allErrors.add(temp.getDefaultMessage());
            }
            modelMap.addAttribute("errors",allErrors);
            return "errors";
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
        // 分类
        Category category = new Category();
        category.setIsDelete(1);
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        modelMap.addAttribute("categoryList",categoryList);

        // 公告
        Announcement announcement = new Announcement();
        announcement.setIsDelete(1);
        List<Announcement> announcements = announcementService.selectAllByCondition(announcement);
        modelMap.addAttribute("announcements",announcements);

        // 热门版主
        Customer customer = new Customer();
        customer.setType(2);
        customer.setIsBm(1);
        customer.setIsUnuse(1);
        List<Customer> customers = customerService.selectAllByCondition(customer); // 查询所有的版主,帖子浏览数和评论数,推选出最热门的版主
        modelMap.addAttribute("customers",customers);

        // 热帖(一周的时间,评选最优帖子 , 条件是以评论数,和浏览数 相加)
        Note note = new Note();
        note.setIsDelete(1);
        List<Note> noteList = noteService.selectAllByCondition(note);
        modelMap.addAttribute("noteList",noteList);

        // 昨日热帖(统计昨天最火爆的帖子)
        Note yestoday_note = new Note();
        yestoday_note.setIsDelete(1);
        List<Note> ytNoteList = noteService.selectAllByCondition(yestoday_note);
        modelMap.addAttribute("ytNoteList",ytNoteList);

        // 每日新帖(展示今天最新发布的帖子)
        Note new_note = new Note();
        new_note.setIsDelete(1);
        List<Note> newNoteList = noteService.selectAllByCondition(new_note);
        modelMap.addAttribute("newNoteList",newNoteList);
        return "index";
    }

    @RequestMapping(value = "/editPass.do",method = RequestMethod.POST)
    @ResponseBody
    public String editPass(String email, String email_code,ModelMap modelMap) { // 校验修改时发送的邮箱验证码是否正确
        if(trueCode.equals(email_code)){
            Customer tempCustomer = new Customer();
            tempCustomer.setEmail(email);
            List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
            if(customers!=null && customers.size()!=0){
                return "";
            }else{
                return "该邮箱还未注册";
            }
        }

        if(!trueCode.equals(email_code)){
            return "邮箱验证码输入错误";
        }
        return "失败";
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

    @RequestMapping(value = "/gotoCenter.do")
    public String gotoCenter(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        return "center";
    }

    @RequestMapping(value = "/gotoMeans.do")
    public String gotoMeans(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        return "edit_means";
    }

    @RequestMapping(value = "/gotoCusDetail.do")
    public String gotoCusDetail(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        return "customer_detail";
    }

    @RequestMapping(value = "/gotoEditPass.do")
    public String gotoEditPass(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        return "edit_password";
    }

    @RequestMapping(value = "/editNewPass.do")
    public void editNewPass(Customer customer) { // 做一个中转
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/gotoNewPass.do")
    public String gotoNewPass(String email,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setEmail(email);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);

        modelMap.addAttribute("now_customer",customers.get(0));
        return "edit_password_newpwd";
    }

    @RequestMapping(value = "/gotoEditQue.do")
    public String gotoEditQue(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);

        modelMap.addAttribute("questionList",customerService.selectAllQuestion());
        modelMap.addAttribute("now_customer",customers.get(0));
        return "edit_question";
    }

    @RequestMapping(value = "/editNewQue.do")
    @ResponseBody
    public void editNewQue(Customer customer,Integer question_id) { // 做一个中转
        Question question = new Question();
        question.setId(question_id);
        customer.setQuestion(question);
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/gotoForgetPass.do")
    public String gotoForgetPass() { // 做一个中转
        return "edit_question";
    }

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/freedom_talk/index.do")
    public String gotoFtIndex(String cus_id , ModelMap modelMap) { // 做一个中转
        // 分类
        Category category = new Category();
        category.setIsDelete(1);
        List<Category> categoryList = categoryService.selectAllByCondition(category);
        modelMap.addAttribute("categoryList",categoryList);

        // 公告
        Announcement announcement = new Announcement();
        announcement.setIsDelete(1);
        List<Announcement> announcements = announcementService.selectAllByCondition(announcement);
        modelMap.addAttribute("announcements",announcements);

        // 热门版主
        Customer customer = new Customer();
        customer.setType(2);
        customer.setIsBm(1);
        customer.setIsUnuse(1);
        List<Customer> customers = customerService.selectAllByCondition(customer); // 查询所有的版主,帖子浏览数和评论数,推选出最热门的版主
        modelMap.addAttribute("customers",customers);

        // 热帖(一周的时间,评选最优帖子 , 条件是以评论数,和浏览数 相加)
        Note note = new Note();
        note.setIsDelete(1);
        List<Note> noteList = noteService.selectAllByCondition(note);
        modelMap.addAttribute("noteList",noteList);

        // 昨日热帖(统计昨天最火爆的帖子)
        Note yestoday_note = new Note();
        yestoday_note.setIsDelete(1);
        List<Note> ytNoteList = noteService.selectAllByCondition(yestoday_note);
        modelMap.addAttribute("ytNoteList",ytNoteList);

        // 每日新帖(展示今天最新发布的帖子)
        Note new_note = new Note();
        new_note.setIsDelete(1);
        List<Note> newNoteList = noteService.selectAllByCondition(new_note);
        modelMap.addAttribute("newNoteList",newNoteList);

        // 当前登录的用户
        if(cus_id!=null){
            Customer tempCustomer = new Customer();
            tempCustomer.setId(cus_id);
            List<Customer> nowcustomers = customerService.selectAllByCondition(tempCustomer);
            modelMap.addAttribute("now_customer",nowcustomers.get(0));
        }

        return "index";
    }
}
