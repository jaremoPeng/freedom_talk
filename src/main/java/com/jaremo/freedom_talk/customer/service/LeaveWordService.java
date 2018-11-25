package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import com.jaremo.freedom_talk.customer.domain.UnLeaveWord;

import java.util.List;

/**
 * @描述: 留言类的服务层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:51
 */
public interface LeaveWordService {

    /**
     * 功能描述 添加留言
     * @author pyj
     * @date 2018/11/2 0002
     * @param leaveWord  留言类
     * @return int 留言成功 1 , 你没有权限 -1 , 其它原因 -2
     */
    int insertLeaveWord(LeaveWord leaveWord);

    /**
     * 功能描述 查询客户的留言板是否是开启的
     * @author pyj
     * @date 2018/11/2 0002
     * @param offId 官方认证标识
     * @param cusId 需要查看的客户id
     * @return void
     */
    LeaveWord selectAllByOfficialId(String offId,String cusId);

    /**
     * 功能描述 修改留言某些状态
     * @author pyj
     * @date 2018/11/2 0002
     * @param leaveWord
     * @return boolean
     */
    boolean updateLeaveWord(LeaveWord leaveWord);

    /**
     * 功能描述 根据条件查询留言
     * @author pyj
     * @date 2018/11/5 0005
     * @param leaveWord
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.LeaveWord>
     */
    List<LeaveWord> selectLwByCondition(LeaveWord leaveWord);

    /**
     * 功能描述 添加禁止留言的用户
     * @author pyj
     * @date 2018/11/5 0005
     * @param unLeaveWord
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.LeaveWord>
     */
    boolean insertUnLw(UnLeaveWord unLeaveWord);

    /**
     * 功能描述 根据fromid和toid查询被禁的用户
     * @author pyj
     * @date 2018/11/5 0005
     * @param unLeaveWord
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.LeaveWord>
     */
    UnLeaveWord selectUnLwById(UnLeaveWord unLeaveWord);
}
