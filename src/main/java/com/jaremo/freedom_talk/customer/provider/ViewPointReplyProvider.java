package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.ViewPointReply;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 观点回复类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 3:17
 */
public class ViewPointReplyProvider {

    public String findAllByCondition(Map map){
        ViewPointReply viewPointReply = (ViewPointReply) map.get("viewPointReply");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_vpreply");
        if(viewPointReply.getId()!=null){
            sql.WHERE("vpr_id=#{viewPointReply.id}");
        }
        if(viewPointReply.getFromCustomer()!=null){
            sql.WHERE("from_id=#{viewPointReply.fromCustomer.id}");
        }
        if(viewPointReply.getToCustomer()!=null){
            sql.WHERE("to_id=#{viewPointReply.toCustomer.id}");
        }
        if(viewPointReply.getIsDelete()!=null){
            sql.WHERE("isDelete=#{viewPointReply.isDelete}");
        }
        if(viewPointReply.getViewPoint()!=null){
            sql.WHERE("viewpoint_id=#{viewPointReply.viewPoint.id}");
        }
        return sql.toString();
    }
}
