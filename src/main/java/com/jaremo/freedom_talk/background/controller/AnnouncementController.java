package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Announcement;
import com.jaremo.freedom_talk.background.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 公告的controller层
 * @Author: pyj
 * @DateTime: 2018/11/13 0013--上午 10:40
 */
@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("/lendacm.do")
    public void lendAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setContent("请各大版主注意,本坛严禁发布涉黄,涉毒,邪教等恶劣性的文章内容,一经发现,将作永久封号处理!!!");

        announcementService.insertAnnouncement(announcement);
    }

    @RequestMapping("/deleteacm.do")
    public void delAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setId(1);

        announcementService.deleteAnnouncement(announcement);
    }

    @RequestMapping("/queryacm.do")
    public void queryAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setId(1);

        List<Announcement> announcements = announcementService.selectAllByCondition(announcement);
        System.out.println(announcements);
    }

}
