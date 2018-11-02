package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.LeaveWord;

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

//    boolean delete
}
