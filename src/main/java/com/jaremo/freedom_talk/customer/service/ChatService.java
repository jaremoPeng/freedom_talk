package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.Chat;

import java.util.List;

/**
 * @描述: 聊天类的service层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 4:56
 */
public interface ChatService {

    /**
     * 功能描述 增添聊天记录
     * @author pyj
     * @date 2018/11/9 0009
     * @param chat
     * @return boolean
     */
    boolean insertChat(Chat chat);

    /**
     * 功能描述 删除聊天记录
     * @author pyj
     * @date 2018/11/9 0009
     * @param chat
     * @return boolean
     */
    boolean deleteChat(Chat chat);

    /**
     * 功能描述 根据条件查询聊天记录
     * @author pyj
     * @date 2018/11/9 0009
     * @param chat
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.Chat>
     */
    List<Chat> selectChatByCondition(Chat chat);
}
