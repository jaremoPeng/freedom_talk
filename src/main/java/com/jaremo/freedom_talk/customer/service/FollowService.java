package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.Follow;

import java.util.List;

/**
 * @描述: 关注的service层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 2:24
 */
public interface FollowService {

    /**
     * 功能描述 添加关注
     * @author pyj
     * @date 2018/11/8 0008
     * @param follow
     * @return int 1 成功添加 , -1 对方不是版主 , -2 其他错误
     */
    int insertFollow(Follow follow);

    /**
     * 功能描述 取消关注
     * @author pyj
     * @date 2018/11/8 0008
     * @param follow
     * @return boolean
     */
    boolean deleteFollow(Follow follow);

    /**
     * 功能描述 根据条件查询我的关注
     * @author pyj
     * @date 2018/11/8 0008
     * @param follow
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.Follow>
     */
    List<Follow> selectFollowByCondition(Follow follow);
}
