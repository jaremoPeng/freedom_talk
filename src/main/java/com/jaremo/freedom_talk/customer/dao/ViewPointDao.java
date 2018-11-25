package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.provider.ViewPointProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 观点的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--上午 10:11
 */
@Repository
public interface ViewPointDao {

    @Insert("insert into tb_viewpoint(vp_content,from_id,vp_time,note_id) " +
            "values (#{viewPoint.content},#{viewPoint.customer.id},#{viewPoint.time},#{viewPoint.note.id})")
    void addViewPoint(@Param("viewPoint") ViewPoint viewPoint);

    @Update("update tb_viewpoint set isDelete=0 where vp_id=#{viewPoint.id} and from_id=#{viewPoint.customer.id}")
    void removeViewPoint(@Param("viewPoint") ViewPoint viewPoint);

    @Results({
            @Result(property = "id",column = "vp_id",id = true),
            @Result(property = "content",column = "vp_content"),
            @Result(property = "time",column = "vp_time"),
            @Result(property = "customer",column = "from_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "note",column = "note_id",javaType = Note.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.NoteDao.findNoteById")),
            @Result(property = "isDelete",column = "isDelete"),
            @Result(property = "viewPointReplyList",column = "vp_id",javaType = List.class,many = @Many(select = "com.jaremo.freedom_talk.customer.dao.ViewPointReplyDao.findAllByVPId"))
    })
    @SelectProvider(type = ViewPointProvider.class,method = "findAllByCondition")
    List<ViewPoint> findAllByCondition(@Param("viewPoint") ViewPoint viewPoint);

    @Results({
            @Result(property = "id",column = "vp_id",id = true),
            @Result(property = "content",column = "vp_content"),
            @Result(property = "time",column = "vp_time"),
            @Result(property = "customer",column = "from_id",javaType = Customer.class , one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "note",column = "note_id",javaType = Note.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.NoteDao.findNoteById")),
            @Result(property = "isDelete",column = "isDelete"),
            @Result(property = "viewPointReplyList",column = "vp_id",javaType = List.class,many = @Many(select = "com.jaremo.freedom_talk.customer.dao.ViewPointReplyDao.findAllByVPId"))
    })
    @Select("select * from tb_viewpoint where vp_id=#{id}")
    ViewPoint findViewPointById(Integer id);
}
