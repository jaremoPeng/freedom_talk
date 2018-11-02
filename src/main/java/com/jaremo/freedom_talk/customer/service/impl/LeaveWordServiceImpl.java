package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.LeaveWordDao;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.service.LeaveWordService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @描述: 留言服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:54
 */
@Service
public class LeaveWordServiceImpl implements LeaveWordService {

    @Autowired
    private LeaveWordDao leaveWordDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean insertLeaveWord(LeaveWord leaveWord) {
        // 应该先判断 [被留言者] 的留言板是否开启,除此,还要判断 [留言者] 有没有被 [被留言者] 禁言

        // 应该给 [被留言者] 发送通知消息
        if(leaveWord!=null){
//            Set<Object> lwCustomers = redisUtil.sGet("lwCustomers");
//            if(lwCustomers!=null){
//                for (Object obj:lwCustomers) {
//                    LeaveWord lw = (LeaveWord)obj;
//
//                    if(lw.getId()==leaveWord.getId() & lw.getIsStart() == 1){
//                        String lwTime = TimeUtil.dateToString(new Date(), 1);
//                        leaveWord.setTime(lwTime); // 设置留言时间
//
//                        leaveWordDao.addLeaveWord(leaveWord);
//                        return true;
//                    }
//                }
//            }else{
                List<LeaveWord> lwList = leaveWordDao.findAllByOfficialId("gfrz");
//                redisUtil.sSet("lwCustomers",lwList);
                for (LeaveWord lw:lwList){
                    if(lw.getId()==leaveWord.getId() & lw.getIsStart() == 1){
                        String lwTime = TimeUtil.dateToString(new Date(), 1);
                        leaveWord.setTime(lwTime); // 设置留言时间

                        leaveWordDao.addLeaveWord(leaveWord);
                        return true;
                    }
                }
//            }
        }
        return false;
    }
}
