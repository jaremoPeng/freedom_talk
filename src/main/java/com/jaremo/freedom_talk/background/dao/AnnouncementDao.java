package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.Announcement;
import com.jaremo.freedom_talk.background.provider.AnnouncementProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 公告类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 9:59
 */
@Repository
public interface AnnouncementDao {

    @Insert("insert into tb_announcement(acm_content,acm_time) " +
            "values (#{announcement.content},#{announcement.time})")
    void addAnnouncement(@Param("announcement") Announcement announcement);

    @Update("update tb_announcement set isDelete=0 where acm_id=#{announcement.id}")
    void removeAnnouncement(@Param("announcement") Announcement announcement);

    @Results({
            @Result(property = "id",column = "acm_id",id = true),
            @Result(property = "content",column = "acm_content"),
            @Result(property = "time",column = "acm_time"),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = AnnouncementProvider.class,method = "findAll")
    List<Announcement> findAllByCondition(@Param("announcement") Announcement announcement);
}
