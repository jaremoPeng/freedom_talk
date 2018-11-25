package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.domain.ViewPointReply;
import com.jaremo.freedom_talk.customer.provider.ViewPointReplyProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 观点回复类数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 3:01
 */
@Repository
public interface ViewPointReplyDao {

    @Insert("insert into tb_vpreply(vpr_content,from_id,to_id,vpr_time,viewpoint_id) " +
            "values(#{viewPointReply.content},#{viewPointReply.fromCustomer.id},#{viewPointReply.toCustomer.id}," +
            "#{viewPointReply.time},#{viewPointReply.viewPoint.id})")
    void addViewPointReply(@Param("viewPointReply") ViewPointReply viewPointReply);

    @Update("update tb_vpreply set isDelete=0 where vpr_id=#{viewPointReply.id} and from_id=#{viewPointReply.fromCustomer.id}")
    void removeViewPointReply(@Param("viewPointReply") ViewPointReply viewPointReply);

    @Results({
            @Result(property = "id",column = "vpr_id",id = true),
            @Result(property = "content",column = "vpr_content"),
            @Result(property = "time",column = "vpr_time"),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "viewPoint",column = "viewpoint_id",javaType = ViewPoint.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.ViewPointDao.findViewPointById")),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = ViewPointReplyProvider.class,method = "findAllByCondition")
    List<ViewPointReply> findAllByCondition(@Param("viewPointReply") ViewPointReply viewPointReply);

    @Results({
            @Result(property = "id",column = "vpr_id",id = true),
            @Result(property = "content",column = "vpr_content"),
            @Result(property = "time",column = "vpr_time"),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "viewPoint",column = "viewpoint_id",javaType = ViewPoint.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.ViewPointDao.findViewPointById")),
            @Result(property = "isDelete",column = "isDelete")
    })
    @Select("select * from tb_vpreply where viewpoint_id=#{vp_id}")
    List<ViewPointReply> findAllByVPId(Integer vp_id);
}
