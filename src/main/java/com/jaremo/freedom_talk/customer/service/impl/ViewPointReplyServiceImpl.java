package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.ViewPointReplyDao;
import com.jaremo.freedom_talk.customer.domain.ReportViewPoint;
import com.jaremo.freedom_talk.customer.domain.ViewPointReply;
import com.jaremo.freedom_talk.customer.service.ViewPointReplyService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @描述: 观点回复类的服务实现层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 3:31
 */
@Service
public class ViewPointReplyServiceImpl implements ViewPointReplyService {

    @Autowired
    private ViewPointReplyDao viewPointReplyDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int insertViewPointReply(ViewPointReply viewPointReply) {
        if(viewPointReply!=null){
//            Set<Object> rvpList = redisUtil.sGet("rvpList");
//            if (rvpList != null) {
//                for (Object obj : rvpList) {
//                    ReportViewPoint tempReportViewPoint = (ReportViewPoint) obj;
//                    if (viewPointReply.getViewPoint().getNote().getId() == tempReportViewPoint.getNote().getId()
//                            && viewPointReply.getFromCustomer().getId() == tempReportViewPoint.getToCustomer().getId()) {
//                        return -1;
//                    }
//                }
//            }
            String time = TimeUtil.dateToString(new Date(),1);
            viewPointReply.setTime(time);

            viewPointReplyDao.addViewPointReply(viewPointReply);
            return 1;
        }
        return -2;
    }

    @Override
    public boolean deleteViewPointReply(ViewPointReply viewPointReply) {
        if(viewPointReply!=null){
            viewPointReplyDao.removeViewPointReply(viewPointReply);
            return true;
        }
        return false;
    }

    @Override
    public List<ViewPointReply> selectAllByCondition(ViewPointReply viewPointReply) {
//        if(viewPointReply.getViewPoint().getId()!=null){
//            List<ViewPointReply> tempList = new ArrayList<>();
//
//            Set<Object> vprList = redisUtil.sGet("vprList");
//            if(vprList!=null){
//                for(Object obj:vprList){
//                    ViewPointReply tempViewPointReply = (ViewPointReply) obj;
//                    if(tempViewPointReply.getViewPoint().getId() == viewPointReply.getViewPoint().getId()){
//                        tempList.add(tempViewPointReply);
//                    }
//                }
//                return tempList;
//            }else{
//                ViewPointReply tempViewPointReply = new ViewPointReply();
//                List<ViewPointReply> viewPointReplyList = viewPointReplyDao.findAllByCondition(tempViewPointReply);
//                redisUtil.sSet("vprList",viewPointReplyList);
//            }
//        }
        if(viewPointReply!=null){
            List<ViewPointReply> viewPointReplyList = viewPointReplyDao.findAllByCondition(viewPointReply);
            return viewPointReplyList;
        }
        return null;
    }
}
