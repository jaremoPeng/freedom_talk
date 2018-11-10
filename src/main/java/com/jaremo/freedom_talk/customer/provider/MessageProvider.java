package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.Message;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 消息类的动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/10 0010--下午 1:08
 */
public class MessageProvider {

    public String editMessage(Map map){
        Message message = (Message) map.get("message");
        SQL sql = new SQL();
        sql.UPDATE("tb_message");
        if(message.getIsDelete()!=null){
            sql.SET("isDelete=#{message.isDelete}");
        }
        if(message.getIsRead()!=null){
            sql.SET("isRead=#{message.isRead}");
        }
        if(message.getId()!=null){
            sql.WHERE("msg_id=#{message.id}");
        }
        return sql.toString();
    }
}
