package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.ReportViewPoint;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 禁止发表观点类sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 1:17
 */
public class ReportViewPointProvider {

    public String findAllByCondition(Map map){
        ReportViewPoint reportViewPoint = (ReportViewPoint) map.get("reportViewPoint");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_report_viewPoint");
        if(reportViewPoint.getId()!=null){
            sql.WHERE("rvp_id=#{reportViewPoint.id}");
        }
        if(reportViewPoint.getFromCustomer()!=null){
            sql.WHERE("from_id=#{reportViewPoint.fromCustomer.id}");
        }
        if(reportViewPoint.getNote()!=null){
            sql.WHERE("note_id=#{reportViewPoint.note.id}");
        }
        if(reportViewPoint.getIsDelete()!=null){
            sql.WHERE("isDelete=#{reportViewPoint.isDelete}");
        }
        return sql.toString();
    }
}
