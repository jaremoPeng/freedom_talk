package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.MessageDao;
import com.jaremo.freedom_talk.customer.domain.Message;
import com.jaremo.freedom_talk.customer.service.MessageService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @描述: 消息类的service层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 1:19
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageDao messageDao;

    @Override
    public boolean insertMsg(Message message) {
        if(message.getContent()!=null && message.getCustomer()!=null){
            String time = TimeUtil.dateToString(new Date(),1);
            message.setTime(time);
            messageDao.addMsg(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMsg(Message message) {
        if(message.getId()!=null && message.getIsDelete()==0){
            messageDao.removeMsg(message);
            return true;
        }
        return false;
    }

    @Override
    public List<Message> selectMsgByCondition(Message message) {
        return messageDao.findMsgByCondition(message);
    }

    @Override
    public boolean updateMsgState(Message message) {
        if(message.getCustomer().getId()!=null && message.getIsRead() == 1){
            messageDao.editMsg(message);
            return true;
        }
        return false;
    }
}
