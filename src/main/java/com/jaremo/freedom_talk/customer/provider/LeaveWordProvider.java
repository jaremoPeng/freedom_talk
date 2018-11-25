package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 留言类的sql语句的动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 1:55
 */
public class LeaveWordProvider {

    // 通用查询
    public String findLeaveWordByCondition(Map map){
        LeaveWord leaveWord = (LeaveWord) map.get("leaveWord");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_leaveword");
        if(leaveWord.getId()!=null){
            sql.WHERE("lw_id=#{leaveWord.id}");
        }
        if(leaveWord.getContent()!=null){
            sql.WHERE("lw_content=#{leaveWord.content}");
        }
        if(leaveWord.getFromCustomer()!=null){
            sql.WHERE("from_id=#{leaveWord.fromCustomer.id}");
        }
        if(leaveWord.getToCustomer()!=null){
            sql.WHERE("to_id=#{leaveWord.toCustomer.id}");
        }
        if(leaveWord.getTime()!=null){
            sql.WHERE("lw_time=#{leaveWord.time}");
        }
        if(leaveWord.getIsStart()!=null){
            sql.WHERE("isStart=#{leaveWord.isStart}");
        }
        if(leaveWord.getIsDelete()!=null){
            sql.WHERE("isDelete=#{leaveWord.isDelete}");
        }
        return sql.toString();
    }

    // 修改留言字段
    public String editLeaveWord(Map map){
        LeaveWord leaveWord = (LeaveWord) map.get("leaveWord");
        SQL sql = new SQL();
        sql.UPDATE("tb_leaveword");
        if(leaveWord.getIsStart()!=null){
            sql.SET("isStart=#{leaveWord.isStart}");
        }
        if(leaveWord.getIsDelete()!=null){
            sql.SET("isDelete=#{leaveWord.isDelete}");
        }
        sql.WHERE("lw_id=#{leaveWord.id}");
        sql.AND();
        sql.WHERE("from_id=#{leaveWord.fromCustomer.id}");
        sql.AND();
        sql.WHERE("to_id=#{leaveWord.toCustomer.id}");
        return sql.toString();
    }
}
