package com.jaremo.freedom_talk.background.provider;

import com.jaremo.freedom_talk.background.domain.Announcement;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 公告类sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 10:12
 */
public class AnnouncementProvider {

    public String findAll(Map map){
        Announcement announcement = (Announcement) map.get("announcement");
        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_announcement");
        if(announcement.getId()!=null){
            sql.WHERE("acm_id=#{announcement.id}");
        }
        if(announcement.getIsDelete()!=null){
            sql.WHERE("isDelete=#{announcement.isDelete}");
        }
        return sql.toString();
    }
}
