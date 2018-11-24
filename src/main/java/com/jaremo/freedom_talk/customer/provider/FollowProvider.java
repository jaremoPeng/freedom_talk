package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.Follow;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 收藏类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:11
 */
public class FollowProvider {

    public String findAllByCondition(Map map){
        Follow follow = (Follow) map.get("follow");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_follow");
        if(follow.getId()!=null){
            sql.WHERE("fol_id=#{follow.id}");
        }
        if(follow.getCustomer()!=null){
            sql.WHERE("customer_id=#{follow.customer.id}");
        }
        if(follow.getModerator()!=null){
            sql.WHERE("moderator_id=#{follow.moderator.id}");
        }
        return sql.toString();
    }
}
