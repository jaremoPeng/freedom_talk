package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.background.domain.Question;
import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.dao.LeaveWordDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.utils.EncryptUtil;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import com.jaremo.freedom_talk.utils.UUIDPlusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * @描述: 客户服务层实现类
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 7:31
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LeaveWordDao leaveWordDao;

//    @Autowired
//    private RedisUtil redisUtil;

    @Override
    public void insertCustomer(Customer customer, Integer questionId) {
        if (customer != null) {
            Question question = new Question();
            question.setId(questionId);

            customer.setQuestion(question);

            String id = UUIDPlusUtil.getUUID();
            customer.setId(id); // 设置客户id

            String newPwd = EncryptUtil.encryptStr(customer.getPassword(), customer.getId()); // 给密码进行加密 , 客户的id作为盐值
            customer.setPassword(newPwd);
            customerDao.addCustomer(customer);

            // 由于构建表的失误, 所以不得不在此出此下策
            LeaveWord leaveWord = new LeaveWord();
            leaveWord.setContent("xxxx");
            leaveWord.setToCustomer(customer);
            Customer from = new Customer();
            from.setId("gfrz");
            String registTime= TimeUtil.dateToString(new Date(),1);
            leaveWord.setTime(registTime);
            leaveWordDao.addLeaveWord(leaveWord);

        } else {

        }
    }

    @Override
    public Customer selectCustomerByLoginName(String loginName) {
//        Set<Object> customerList = redisUtil.sGet("customerList"); // 先获取redis的中的customer集合
//        if (customerList != null) {
//            for (Object obj : customerList) {
//                Customer cus = (Customer) obj;
//                if (cus.getLoginName().equals(loginName)) {
//                    return cus;
//                }
//            }
//        }
        Customer customer = customerDao.findCustomerByLoginName(loginName); // 如果集合中没有对应的数据,再到数据库中查询
        if (customer != null) {
//            redisUtil.sSet("customerList", customer); // 如果数据库中查到了对应的数据 则把它放入到redis中,以便下次查询
            return customer;
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(customer!=null){
            if(customer.getPassword() != null){ // 修改密码的话需要重新加密
                String newPwd = EncryptUtil.encryptStr(customer.getPassword(),customer.getId());
                customer.setPassword(newPwd);
            }
            if(customer.getBirthdate() != null){
                Integer age = TimeUtil.confirmAge(customer.getBirthdate()); // 根据出生年月确定年龄
                customer.setAge(age);
            }
            customerDao.alterCustomer(customer);
        }
    }
}
