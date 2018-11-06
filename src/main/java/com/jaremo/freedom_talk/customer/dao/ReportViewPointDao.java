package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.domain.ReportViewPoint;
import com.jaremo.freedom_talk.customer.provider.ReportViewPointProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述: 禁止发表观点类的数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 1:08
 */
@Repository
public interface ReportViewPointDao {

    @Insert("insert into tb_report_viewpoint(note_id,from_id,to_id) " +
            "values (#{reportViewPoint.note.id},#{reportViewPoint.fromCustomer.id},#{reportViewPoint.toCustomer.id})")
    void addReportViewPoint(@Param("reportViewPoint") ReportViewPoint reportViewPoint);

    @Update("update tb_report_viewpoint set isDelete=0 where rvp_id=#{id}")
    void removeReportViewPoint(Integer id);

    @Results({
            @Result(property = "id",column = "rvp_id",id = true),
            @Result(property = "note",column = "note_id",javaType = Note.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.NoteDao.findNoteById")),
            @Result(property = "fromCustomer",column = "from_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "toCustomer",column = "to_id",javaType = Customer.class,one = @One(select = "com.jaremo.freedom_talk.customer.dao.CustomerDao.findCustomerById")),
            @Result(property = "isDelete",column = "isDelete")
    })
    @SelectProvider(type = ReportViewPointProvider.class,method = "findAllByCondition")
    List<ReportViewPoint> findAllByCondition(@Param("reportViewPoint") ReportViewPoint reportViewPoint);
}
