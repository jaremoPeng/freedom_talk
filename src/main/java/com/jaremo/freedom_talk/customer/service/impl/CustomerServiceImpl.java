package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.background.domain.Question;
import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.utils.EncryptUtil;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.UUIDPlusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述: 客户服务层实现类
 * @Author: pyj
 * @DateTime: 2018/10/30 0030--下午 7:31
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

//    @Autowired
//    private RedisUtil redisUtil;

    @Override
    public void insertCustomer(Customer customer , Integer questionId) {
        if(customer!=null){
            Question question = new Question();
            question.setId(questionId);

            customer.setQuestion(question);

            String id = UUIDPlusUtil.getUUID();
            customer.setId(id); // 设置客户id

            String newPwd = EncryptUtil.encryptStr(customer.getPassword(),customer.getId()); // 给密码进行加密 , 客户的id作为盐值
            customer.setPassword(newPwd);
            System.err.println(customer);
            customerDao.addCustomer(customer);
        }else{

        }
    }
}
