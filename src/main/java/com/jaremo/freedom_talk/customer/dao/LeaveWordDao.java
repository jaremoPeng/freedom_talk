package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.LeaveWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @描述: 留言类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--上午 8:33
 */
@Repository
public interface LeaveWordDao {

    @Insert("insert into tb_leaveword(lw_content,from_id,to_id,lw_time) " +
            "values (#{leaveWord.content},#{leaveWord.fromCustomer.id},#{leaveWord.toCustomer.id},#{leaveWord.time})")
    void addLeaveWord(@Param("leaveWord") LeaveWord leaveWord);
}
