package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 观点类sql语句拼接
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--上午 10:28
 */
public class ViewPointProvider {

    public String findAllByCondition(Map map){
        ViewPoint viewPoint = (ViewPoint) map.get("viewPoint");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_viewpoint");
        if(viewPoint.getId()!= null){
            sql.WHERE("vp_id=#{viewPoint.id}");
        }
        if(viewPoint.getCustomer()!= null){
            sql.WHERE("from_id=#{viewPoint.customer.id}");
        }
        if(viewPoint.getIsDelete()!= null){
            sql.WHERE("isDelete=#{viewPoint.isDelete}");
        }
        if(viewPoint.getNote()!= null){
            sql.WHERE("note_id=#{viewPoint.note.id}");
        }
        return sql.toString();
    }
}
