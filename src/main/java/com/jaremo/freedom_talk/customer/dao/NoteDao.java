package com.jaremo.freedom_talk.customer.dao;

import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.provider.NoteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @描述: 帖子数据访问层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:23
 */
@Repository
public interface NoteDao {

    @InsertProvider(type = NoteProvider.class,method = "addNote")
    void addNote(@Param("note") Note note);


}
