package com.jaremo.freedom_talk.background.service;

import com.jaremo.freedom_talk.background.domain.Announcement;

import java.util.List;

/**
 * @描述: 公告的service层
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 10:24
 */
public interface AnnouncementService {

    /**
     * 功能描述 添加公告
     * @author pyj
     * @date 2018/11/13 0013
     * @param announcement
     * @return boolean
     */
    boolean insertAnnouncement(Announcement announcement);

    /**
     * 功能描述 删除公告
     * @author pyj
     * @date 2018/11/13 0013
     * @param announcement
     * @return boolean
     */
    boolean deleteAnnouncement(Announcement announcement);

    /**
     * 功能描述 根据条件查询
     * @author pyj
     * @date 2018/11/13 0013
     * @param announcement
     * @return java.util.List<com.jaremo.freedom_talk.background.domain.Announcement>
     */
    List<Announcement> selectAllByCondition(Announcement announcement);
}
