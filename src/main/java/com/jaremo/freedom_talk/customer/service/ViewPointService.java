package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.ViewPoint;

import java.util.List;

/**
 * @描述: 观点类服务层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--上午 10:45
 */
public interface ViewPointService {

    /**
     * 功能描述 增添观点
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPoint
     * @return boolean
     */
    boolean insetViewPoint(ViewPoint viewPoint);

    /**
     * 功能描述 删除观点
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPoint
     * @return boolean
     */
    boolean deleteViewPoint(ViewPoint viewPoint);

    /**
     * 功能描述 根据条件查询观点
     * @author pyj
     * @date 2018/11/6 0006
     * @param viewPoint
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.ViewPoint>
     */
    List<ViewPoint> selectAllByCondition(ViewPoint viewPoint);
}
