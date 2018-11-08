package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.CollectDao;
import com.jaremo.freedom_talk.customer.domain.Collect;
import com.jaremo.freedom_talk.customer.service.CollectService;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @描述: 收藏类service层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:28
 */
@Service
public class CollectServiceImpl implements CollectService{

    @Autowired
    private CollectDao collectDao;

    @Override
    public int insertCollect(Collect collect) {
        String time = TimeUtil.dateToString(new Date(),1);

        List<Collect> collectList = collectDao.findAllByCondition(collect);
        if(collectList!=null && collectList.size()!=0){
            Collect tempCollect = collectList.get(0);
            if(tempCollect.getIsDelete()==1){
                return -1;
            }else{
                tempCollect.setTime(time);
                tempCollect.setIsDelete(1);
                collectDao.editCollect(tempCollect);
                return 1;
            }
        }
        if(collectList==null || collectList.size()==0){
            collect.setTime(time);
            collectDao.addCollect(collect);
            return 1;
        }

        return -2;
    }

    @Override
    public boolean deleteCollect(Collect collect) {
        if(collect.getCustomer()!=null && collect.getNote()!=null){
            collectDao.removeCollect(collect);
            return true;
        }
        return false;
    }

    @Override
    public List<Collect> selectAllByCondition(Collect collect) {
        if(collect!=null){
            return collectDao.findAllByCondition(collect);
        }
        return null;
    }
}
