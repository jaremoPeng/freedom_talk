package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.ViewPointDao;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述: 观点类的服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--上午 10:54
 */
@Service
public class ViewPointServiceImpl implements ViewPointService{

    @Autowired
    private ViewPointDao viewPointDao;

    @Override
    public boolean insetViewPoint(ViewPoint viewPoint) {
        // 要先判断是否被版主所禁言

        return false;
    }

    @Override
    public boolean deleteViewPoint(ViewPoint viewPoint) {
        return false;
    }

    @Override
    public List<ViewPoint> selectAllByCondition(ViewPoint viewPoint) {
        return null;
    }
}
