package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.UnLeaveWord;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 禁止留言的提供类
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 1:16
 */
public class UnLeaveWordProvider {

    // 通用查询
    public String queryUnLeaveWordByCondition(Map map){
        UnLeaveWord unLeaveWord = (UnLeaveWord) map.get("unLeaveWord");

        SQL sql = new SQL();
        sql.SELECT("*").FROM("tb_unleave_word");
        if(unLeaveWord.getId()!=null){
            sql.WHERE("ulw_id=#{unLeaveWord.id}");
        }
        if(unLeaveWord.getFromCustomer()!=null){
            sql.WHERE("from_id=#{unLeaveWord.fromCustomer.id}");
        }
        if(unLeaveWord.getToCustomer()!=null){
            sql.WHERE("to_id=#{unLeaveWord.toCustomer.id}");
        }
        if(unLeaveWord.getIsDelete()!=null){
            sql.WHERE("isDelete=#{unLeaveWord.isDelete}");
        }
        return sql.toString();
    }
}
