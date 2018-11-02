package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.LeaveWordReply;

import java.util.List;

/**
 * @描述: 留言回复类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 5:15
 */
public interface LeaveWordReplyService {

    /**
     * 功能描述 添加留言回复
     * @author pyj
     * @date 2018/11/2 0002
     * @param leaveWordReply
     * @return boolean
     */
    boolean insertLeaveWordReply(LeaveWordReply leaveWordReply);

    /**
     * 功能描述 根据条件查询留言回复类
     * @author pyj
     * @date 2018/11/2 0002
     * @param leaveWordReply
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.LeaveWordReply>
     */
    List<LeaveWordReply> selectLeaveWordReplyByCondition(LeaveWordReply leaveWordReply);

}
