package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.Collect;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 收藏类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:11
 */
public class CollectProvider {

    public String findAllByCondition(Map map){
        Collect collect = (Collect) map.get("collect");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_collect");
        if(collect.getId()!=null){
            sql.WHERE("col_id=#{collect.id}");
        }
        if(collect.getCustomer()!=null){
            sql.WHERE("customer_id=#{collect.customer.id}");
        }
        if(collect.getIsDelete()!=null){
            sql.WHERE("isDelete=#{collect.isDelete}");
        }
        return sql.toString();
    }

    public String editCollect(Map map){
        Collect collect = (Collect) map.get("collect");
        SQL sql = new SQL();
        sql.UPDATE("tb_collect");
        if(collect.getId()!=null){
            sql.WHERE("col_id=#{collect.id}");
        }
        if(collect.getCustomer()!=null){
            sql.WHERE("customer_id=#{collect.customer.id}");
        }
        if(collect.getIsDelete()!=null){
            sql.SET("isDelete=#{collect.isDelete}");
        }
        if(collect.getTime()!=null){
            sql.SET("col_time=#{collect.time}");
        }
        return sql.toString();
    }
}
