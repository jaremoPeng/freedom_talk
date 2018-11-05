package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.dao.NoteDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.NoteService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @描述: 帖子服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:55
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean insertNote(Note note, String customer_id) {

        Customer customer = customerDao.findCustomerById(customer_id);
        if(customer.getIsBm()==1 && customer.getType() == 2){ // 证明该客户是版主
            String noteTime = TimeUtil.dateToString(new Date(), 1);
            note.setTime(noteTime);
            note.setCustomer(customer);

            noteDao.addNote(note);
            return true;
        }
        return false;
    }
}

