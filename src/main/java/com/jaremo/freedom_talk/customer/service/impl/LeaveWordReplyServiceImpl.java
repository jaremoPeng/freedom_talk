package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.LeaveWordReplyDao;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @描述: 留言回复类service层的实现
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 5:16
 */
@Service
public class LeaveWordReplyServiceImpl implements LeaveWordReplyService {

    @Autowired
    private LeaveWordReplyDao leaveWordReplyDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean insertLeaveWordReply(LeaveWordReply leaveWordReply) {
        if(leaveWordReply!=null){
            String replyTime = TimeUtil.dateToString(new Date(),1);
            leaveWordReply.setReplyTime(replyTime);

            leaveWordReplyDao.addLeaveWordReply(leaveWordReply);
            return true;
        }
        return false;
    }

    @Override
    public List<LeaveWordReply> selectLeaveWordReplyByCondition(LeaveWordReply leaveWordReply) {
//        Set<Object> lwReplys = redisUtil.sGet("lwReplys");
//
//
//        if(lwReplys!=null){
//            List<LeaveWordReply> tempLwrList = new ArrayList<>();
//            for(Object obj:lwReplys){
//                LeaveWordReply lwr = (LeaveWordReply) obj;
//
//                if(lwr.getLeaveWord().getId() == leaveWordReply.getLeaveWord().getId()){ // 这里只根据留言id来查询它的回复留言列表
//                    tempLwrList.add(lwr);
//                }
//            }
//            return tempLwrList;
//        }else{
//            LeaveWordReply tempLeaveWordReply = null;
//            List<LeaveWordReply> allLeaveWordReply = leaveWordReplyDao.findLeaveWordReplyByCondition(tempLeaveWordReply);
//            redisUtil.sSet("lwReplys",allLeaveWordReply); // 给全部留言回复  都放到redis里面

            List<LeaveWordReply> leaveWordReplyList = leaveWordReplyDao.findLeaveWordReplyByCondition(leaveWordReply);
            return leaveWordReplyList;
//        }
    }

    @Override
    public boolean deleteLeaveWordReply(LeaveWordReply leaveWordReply) {
        if(leaveWordReply!=null){
            leaveWordReplyDao.removeLeaveWordReply(leaveWordReply);
            return true;
        }
        return false;
    }
}
