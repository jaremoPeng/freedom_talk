package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.Message;

import java.util.List;

/**
 * @描述: 消息类的service层
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 1:18
 */
public interface MessageService {

    /**
     * 功能描述 添加消息
     * @author pyj
     * @date 2018/11/15 0015
     * @param message
     * @return boolean
     */
    boolean insertMsg(Message message);

    /**
     * 功能描述 删除消息
     * @author pyj
     * @date 2018/11/10 0010
     * @param message
     * @return boolean
     */
    boolean deleteMsg(Message message);

    /**
     * 功能描述 查询消息根据条件
     * @author pyj
     * @date 2018/11/10 0010
     * @param message
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.Message>
     */
    List<Message> selectMsgByCondition(Message message);

    /**
     * 功能描述 修改消息的状态
     * @author pyj
     * @date 2018/11/23 0023
     * @param message
     * @return boolean
     */
    boolean updateMsgState(Message message);
}
