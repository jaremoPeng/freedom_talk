package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.LeaveWordDao;
import com.jaremo.freedom_talk.customer.dao.UnLeaveWordDao;
import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.UnLeaveWord;
import com.jaremo.freedom_talk.customer.service.LeaveWordService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @描述: 留言服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:54
 */
@Service
public class LeaveWordServiceImpl implements LeaveWordService {

    @Autowired
    private LeaveWordDao leaveWordDao;

    @Autowired
    private UnLeaveWordDao unLeaveWordDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int insertLeaveWord(LeaveWord leaveWord) {
        if (leaveWord != null) {
            // 判断 [留言者] 有没有被 [被留言者] 禁言
            UnLeaveWord unLeaveWord = new UnLeaveWord();
            unLeaveWord.setFromCustomer(leaveWord.getToCustomer());
            unLeaveWord.setToCustomer(leaveWord.getFromCustomer());
            List<UnLeaveWord> unLeaveWordList = unLeaveWordDao.findUnLeaveWordByCondition(unLeaveWord);

            if(unLeaveWordList!=null && unLeaveWordList.size()!=0){
                System.out.println(unLeaveWordList);
                return -1; // 被禁言了
            }

            String time = TimeUtil.dateToString(new Date(),1);
            leaveWord.setTime(time);
            leaveWordDao.addLeaveWord(leaveWord);
            // 应该给 [被留言者] 发送通知消息
            return 1;
        }
        return -2;
    }

    @Override
    public LeaveWord selectAllByOfficialId(String offId, String cusId) {
        Set<Object> lwCustomers = redisUtil.sGet("lwCustomers");
        if (lwCustomers != null) {
            for (Object obj : lwCustomers) {
                LeaveWord lw = (LeaveWord) obj;

                if (lw.getToCustomer().getId().equals(cusId) & lw.getIsStart() == 1) {
                    return lw;
                }
            }
        } else {
            List<LeaveWord> lwList = leaveWordDao.findAllByOfficialId("gfrz");
            redisUtil.sSet("lwCustomers",lwList);

            for (LeaveWord leaveWord : lwList) {
                if (leaveWord.getToCustomer().getId().equals(cusId) & leaveWord.getIsStart() == 1) {
                    return leaveWord;
                }
            }
        }
        return null;
    }

    @Override
    public boolean updateLeaveWord(LeaveWord leaveWord) {
        if(leaveWord!=null){
            leaveWordDao.editLeaveWordByCondition(leaveWord);
            return true;
        }
        return false;
    }

    @Override
    public List<LeaveWord> selectLwByCondition(LeaveWord leaveWord) {
        List<LeaveWord> leaveWordList = leaveWordDao.findLeaveWordByCondition(leaveWord);
        return leaveWordList;
    }

    @Override
    public boolean insertUnLw(UnLeaveWord unLeaveWord) {
        UnLeaveWord checkUnlw = selectUnLwById(unLeaveWord);
        if(checkUnlw!=null){ // 判断是否存在
            if(checkUnlw.getIsDelete()==0){
                checkUnlw.setIsDelete(1);
                unLeaveWordDao.editUnLeaveWord(checkUnlw);
                return true;
            }
        }
        if(checkUnlw==null){
            unLeaveWordDao.addUnleaveWord(unLeaveWord);
            return true;
        }
        return false;
    }

    @Override
    public UnLeaveWord selectUnLwById(UnLeaveWord unLeaveWord) {
        List<UnLeaveWord> unLeaveWordList = unLeaveWordDao.findUnLeaveWordByCondition(unLeaveWord);
        if(unLeaveWordList!=null && unLeaveWordList.size()>0){
            return unLeaveWordList.get(0);
        }
        return null;
    }

    @Override
    public List<UnLeaveWord> selectUnLwByFromCustomer(UnLeaveWord unLeaveWord) {
        List<UnLeaveWord> unLeaveWordList = unLeaveWordDao.findUnLeaveWordByCondition(unLeaveWord);
        if(unLeaveWordList!=null && unLeaveWordList.size()>0){
            return unLeaveWordList;
        }
        return null;
    }
}
