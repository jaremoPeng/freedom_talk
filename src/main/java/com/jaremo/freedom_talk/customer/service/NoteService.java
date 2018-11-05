package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.Note;

/**
 * @描述: 帖子的服务层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:55
 */
public interface NoteService {

    boolean insertNote(Note note,String customer_id);
}
