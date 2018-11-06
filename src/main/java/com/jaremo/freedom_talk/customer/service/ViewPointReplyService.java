package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.ViewPointReply;

import java.util.List;

/**
 * @描述: 观点回复类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 3:30
 */
public interface ViewPointReplyService {

    /**
     * 功能描述 增添观点回复
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPointReply
     * @return int 1 成功 , -1 被禁言 , -2 其他错误
     */
    int insertViewPointReply(ViewPointReply viewPointReply);

    /**
     * 功能描述 删除观点回复
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPointReply
     * @return boolean
     */
    boolean deleteViewPointReply(ViewPointReply viewPointReply);

    /**
     * 功能描述 根据条件查询观点回复
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPointReply
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.ViewPointReply>
     */
    List<ViewPointReply> selectAllByCondition(ViewPointReply viewPointReply);
}
