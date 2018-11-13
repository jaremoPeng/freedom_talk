package com.jaremo.freedom_talk.background.service.impl;

import com.jaremo.freedom_talk.background.dao.AnnouncementDao;
import com.jaremo.freedom_talk.background.domain.Announcement;
import com.jaremo.freedom_talk.background.service.AnnouncementService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @描述: 公告类的service层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 10:33
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService{

    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public boolean insertAnnouncement(Announcement announcement) {
        if(announcement.getContent()!=null){
            String time = TimeUtil.dateToString(new Date(),1);
            announcement.setTime(time);

            announcementDao.addAnnouncement(announcement);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAnnouncement(Announcement announcement) {
        if(announcement != null){
            announcementDao.removeAnnouncement(announcement);
            return true;
        }
        return false;
    }

    @Override
    public List<Announcement> selectAllByCondition(Announcement announcement) {
        return announcementDao.findAllByCondition(announcement);
    }
}
