package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.ReportViewPointDao;
import com.jaremo.freedom_talk.customer.dao.ViewPointDao;
import com.jaremo.freedom_talk.customer.domain.ReportViewPoint;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.service.ViewPointService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ReportViewPointDao reportViewPointDao;

    @Override
    public int insertViewPoint(ViewPoint viewPoint) {
        if(viewPoint!=null){
            // 要先判断是否被版主所禁言
            ReportViewPoint reportViewPoint = new ReportViewPoint();
            reportViewPoint.setNote(viewPoint.getNote());
            reportViewPoint.setToCustomer(viewPoint.getCustomer());

            List<ReportViewPoint> rViewPointList = reportViewPointDao.findAllByCondition(reportViewPoint);
            if (rViewPointList!=null && rViewPointList.size()!=0){
                return -1; // 被禁言
            }

            String time = TimeUtil.dateToString(new Date(),1);
            viewPoint.setTime(time);

            viewPointDao.addViewPoint(viewPoint);
            return 1;
        }
        return -2;
    }

    @Override
    public boolean deleteViewPoint(ViewPoint viewPoint) {
        // 当前viewpoint的fromCustomer 是否和 session中的已登录的Customer一致(要先做这一判断)
        if(viewPoint!=null){
            viewPointDao.removeViewPoint(viewPoint);
            return true;
        }
        return false;
    }

    @Override
    public List<ViewPoint> selectAllByCondition(ViewPoint viewPoint) {
        if(viewPoint!=null){
            List<ViewPoint> viewPointList = viewPointDao.findAllByCondition(viewPoint);
            return viewPointList;
        }
        return null;
    }
}
