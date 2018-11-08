package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.dao.FollowDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Follow;
import com.jaremo.freedom_talk.customer.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述: 关注类的service实现类
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 2:37
 */
@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private FollowDao followDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public int insertFollow(Follow follow) {
        Customer moderator = customerDao.findCustomerById(follow.getModerator().getId());
        if(moderator.getIsBm()!=1){
            return -1;
        }
        if(moderator.getIsBm()==1){
            followDao.addFollow(follow);
            return 1;
        }
        return -2;
    }

    @Override
    public boolean deleteFollow(Follow follow) {
        if(follow.getModerator()!=null && follow.getCustomer()!=null){
            followDao.removeFollow(follow);
            return true;
        }
        return false;
    }

    @Override
    public List<Follow> selectFollowByCondition(Follow follow) {
        if(follow!=null){
            return followDao.findFollowByCondition(follow);
        }
        return null;
    }
}
