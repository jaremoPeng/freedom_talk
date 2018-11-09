package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.HailFellowDao;
import com.jaremo.freedom_talk.customer.domain.HailFellow;
import com.jaremo.freedom_talk.customer.service.HailFellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述: 好友类的service层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/9 0009--下午 1:50
 */
@Service
public class HailFellowSeviceImpl implements HailFellowService{

    @Autowired
    private HailFellowDao hailFellowDao;

    @Override
    public int insertHailFellow(HailFellow hailFellow) {
        List<HailFellow> hailFellowList = hailFellowDao.findHailFellowByCondition(hailFellow);
        if(hailFellowList != null && hailFellowList.size()!=0){
            for (HailFellow tempHf : hailFellowList){
                if(hailFellow.getToCustomer().getId() == tempHf.getToCustomer().getId()){
                    return -1; // 已存在好友
                }
            }
        }

        if(hailFellowList == null || hailFellowList.size()==0){
            // 给对方发送请求添加好友消息, 待对方同意以后可相互成为好友
            hailFellowDao.addHailFellow(hailFellow);

            HailFellow tempHf = new HailFellow();
            tempHf.setFromCustomer(hailFellow.getToCustomer());
            tempHf.setToCustomer(hailFellow.getFromCustomer());
            hailFellowDao.addHailFellow(tempHf);
            return 1;
        }
        return -2;
    }

    @Override
    public boolean deleteHailFellow(HailFellow hailFellow) {
        if(hailFellow!=null){
            hailFellowDao.removeHailFellow(hailFellow); // 删除好友

            HailFellow tempHf = new HailFellow();
            tempHf.setFromCustomer(hailFellow.getToCustomer()); // 同时还要删除删除对方好友列表中的ni
            tempHf.setToCustomer(hailFellow.getFromCustomer());
            hailFellowDao.removeHailFellow(tempHf);
            return true;
        }
        return false;
    }

    @Override
    public List<HailFellow> selectHailFellowByCondition(HailFellow hailFellow) {
        return hailFellowDao.findHailFellowByCondition(hailFellow);
    }

    @Override
    public boolean updateHailFellow(HailFellow hailFellow) {
        if(hailFellow!=null){
            hailFellowDao.editHailFellow(hailFellow);
            return true;
        }
        return false;
    }
}
