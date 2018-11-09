package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.HailFellow;

import java.util.List;

/**
 * @描述: 好友类的service层
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 1:41
 */
public interface HailFellowService {

    /**
     * 功能描述 添加好友
     * @author pyj
     * @date 2018/11/9 0009
     * @param hailFellow
     * @return int
     */
    int insertHailFellow(HailFellow hailFellow);

    /**
     * 功能描述 删除好友
     * @author pyj
     * @date 2018/11/9 0009
     * @param hailFellow
     * @return boolean
     */
    boolean deleteHailFellow(HailFellow hailFellow);

    /**
     * 功能描述 修改好友
     * @author pyj
     * @date 2018/11/9 0009
     * @param hailFellow
     * @return boolean
     */
    boolean updateHailFellow(HailFellow hailFellow);

    /**
     * 功能描述 根据条件查询好友
     * @author pyj
     * @date 2018/11/9 0009
     * @param hailFellow
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.HailFellow>
     */
    List<HailFellow> selectHailFellowByCondition(HailFellow hailFellow);
}
