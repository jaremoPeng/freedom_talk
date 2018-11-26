package com.jaremo.freedom_talk.background.controller;

import com.jaremo.freedom_talk.background.domain.Announcement;
import com.jaremo.freedom_talk.background.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/lendacm.do",method = RequestMethod.POST)
    @ResponseBody
    public String lendAnnouncement(String content){
        Announcement announcement = new Announcement();
        announcement.setContent(content);

        boolean result = announcementService.insertAnnouncement(announcement);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping(value = "/deleteacm.do",method = RequestMethod.POST)
    @ResponseBody
    public String delAnnouncement(Integer acid){
        Announcement announcement = new Announcement();
        announcement.setId(acid);

        boolean result = announcementService.deleteAnnouncement(announcement);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping("/gotoBgACAdd.do")
    public String gotoBgACAdd(){
        return "bg_ac_add";
    }

    @RequestMapping("/gotoBgACList.do")
    public String gotoBgACList(ModelMap modelMap){
        Announcement announcement = new Announcement();
        announcement.setIsDelete(1);
        List<Announcement> announcements = announcementService.selectAllByCondition(announcement);
        modelMap.addAttribute("announcements",announcements);
        return "bg_ac_list";
    }

}
