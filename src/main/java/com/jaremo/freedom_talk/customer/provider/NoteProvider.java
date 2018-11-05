package com.jaremo.freedom_talk.customer.provider;

import com.jaremo.freedom_talk.customer.domain.Note;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @描述: 帖子类的sql语句动态拼接
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:33
 */
public class NoteProvider {

    public String addNote(Map map){
        Note note = (Note) map.get("note");
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_note");
        if(note.getImg()!=null){
            sql.VALUES("note_img","#{note.img}");
        }
        if(note.getCategory()!=null){
            sql.VALUES("note_category","#{note.category.id}");
        }
        if(note.getContent()!=null){
            sql.VALUES("note_content","#{note.content}");
        }
        if(note.getCustomer()!=null){
            sql.VALUES("customer_id","#{note.customer.id}");
        }
        if(note.getTime()!=null){
            sql.VALUES("note_time","#{note.time}");
        }
        if(note.getTitle()!=null){
            sql.VALUES("note_title","#{note.title}");
        }
        return sql.toString();
    }
}
