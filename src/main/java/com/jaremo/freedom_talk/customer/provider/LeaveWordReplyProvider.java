package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 留言回复类的sql语句的动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 4:44
 */
public class LeaveWordReplyProvider {

    public String findLeaveWordReplyByCondition(Map map){
        LeaveWordReply leaveWordReply = (LeaveWordReply) map.get("leaveWordReply");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_lwreply");
        if(leaveWordReply.getId()!=null){
            sql.WHERE("lwr_id=#{leaveWordReply.id}");
        }
        if(leaveWordReply.getFromCustomer()!=null){
            sql.WHERE("from_id=#{leaveWordReply.fromCustomer.id}");
        }
        if(leaveWordReply.getToCustomer()!=null){
            sql.WHERE("to_id=#{leaveWordReply.toCustomer.id}");
        }
        if(leaveWordReply.getLeaveWord()!=null){
            sql.WHERE("leaveword_id=#{leaveWordReply.leaveWord.id}");
        }
        if(leaveWordReply.getIsDelete()!=null){
            sql.WHERE("isDelete=#{leaveWordReply.isDelete}");
        }
        return sql.toString();
    }

    public String editLeaveWordReply(Map map){
        LeaveWordReply leaveWordReply = (LeaveWordReply) map.get("leaveWordReply");
        SQL sql = new SQL();
        sql.UPDATE("tb_lwreply");
        sql.SET("isDelete=#{leaveWordReply.isDelete}");
        if(leaveWordReply.getId()!=null){
            sql.WHERE("lwr_id=#{leaveWordReply.id}");
        }
        if(leaveWordReply.getLeaveWord()!=null){
            sql.WHERE("leaveword_id=#{leaveWordReply.leaveWord.id}");
        }
        if(leaveWordReply.getFromCustomer()!=null){
            sql.WHERE("leaveword_id=#{leaveWordReply.fromCustomer.id}");
        }
        if(leaveWordReply.getToCustomer()!=null){
            sql.WHERE("leaveword_id=#{leaveWordReply.toCustomer.id}");
        }
        return sql.toString();
    }
}
