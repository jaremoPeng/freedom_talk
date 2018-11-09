package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.ChatDao;
import com.jaremo.freedom_talk.customer.domain.Chat;
import com.jaremo.freedom_talk.customer.service.ChatService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @描述: 聊天记录的service层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 5:01
 */
@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatDao chatDao;

    @Override
    public boolean insertChat(Chat chat) {
        if(chat.getFromCustomer()!=null && chat.getToCustomer()!=null){
            String time = TimeUtil.dateToString(new Date(),1);
            chat.setTime(time);

            chatDao.addChat(chat);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteChat(Chat chat) {
        if(chat.getToCustomer()!=null && chat.getFromCustomer()!=null){
            chatDao.removeChat(chat); // 不单单只删除自己发送给别人的

            Chat temp = new Chat(); // 还要删除别人发送给自己的
            temp.setFromCustomer(chat.getToCustomer());
            temp.setToCustomer(chat.getFromCustomer());
            chatDao.removeChat(temp);
            return true;
        }
        return false;
    }

    @Override
    public List<Chat> selectChatByCondition(Chat chat) {
        List<Chat> chatList = chatDao.findChatByCondition(chat); // 不单单只查询自己发送给别人的

        Chat temp = new Chat(); // 还要查询别人发送给自己的
        temp.setFromCustomer(chat.getToCustomer());
        temp.setToCustomer(chat.getFromCustomer());
        List<Chat> otherChatList = chatDao.findChatByCondition(temp);

        for (Chat tempChat:otherChatList){
            chatList.add(tempChat);
        }
        return chatList;
    }
}
