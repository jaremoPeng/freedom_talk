package com.jaremo.freedom_talk.background.dao;

import com.jaremo.freedom_talk.background.domain.Question;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @描述: 问题类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/10/31 0031--上午 9:33
 */
@Repository
public interface QuestionDao {

    @Select("select que_id as id , que_content as questionContent from tb_login_question where que_id=#{id}")
    Question findQuestionById(Integer id);
}
