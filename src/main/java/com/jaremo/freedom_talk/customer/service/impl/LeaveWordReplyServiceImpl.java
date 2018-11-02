package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.LeaveWordReplyDao;
import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;
import com.jaremo.freedom_talk.customer.service.LeaveWordReplyService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Set<Object> lwReplys = redisUtil.sGet("lwReplys");
        if(lwReplys!=null){

        }else{

        }

        return null;
    }
}
