package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.LeaveWord;

/**
 * @描述: 留言类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:51
 */
public interface LeaveWordService {

    /**
     * 功能描述 添加留言
     * @author pyj
     * @date 2018/11/2 0002
     * @param leaveWord  留言类
     * @return boolean 留言成功 true , 失败 false
     */
    boolean insertLeaveWord(LeaveWord leaveWord);
}
