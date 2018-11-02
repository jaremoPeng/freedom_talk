package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.UnLeaveWord;
import com.jaremo.freedom_talk.customer.provider.UnLeaveWordProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 禁止客户留言数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/2 0002--下午 1:07
 */
@Repository
public interface UnLeaveWordDao {

    @Insert("insert into tb_unleave_word(from_id,to_id) values(#{unLeaveWord.fromCustomer.id},#{unLeaveWord.toCustomer.id})")
    void addUnleaveWord(@Param("unLeaveWord") UnLeaveWord unLeaveWord);

    @Results({
            @Result(id = true , property = "id",column = "ulw_id"),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = UnLeaveWordProvider.class,method = "queryUnLeaveWordByCondition")
    List<UnLeaveWord> findUnLeaveWordByCondition(@Param("unLeaveWord") UnLeaveWord unLeaveWord);

    @Update("update tb_unleave_word set isDelete=#{unLeaveWord.isDelete} where from_id=#{unLeaveWord.fromCustomer.id} and to_id=#{unLeaveWord.toCustomer.id}")
    void editUnLeaveWord(@Param("unLeaveWord") UnLeaveWord unLeaveWord);
}
