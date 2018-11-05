package com.jaremo.freedom_talk.customer.service.impl;

import com.jaremo.freedom_talk.customer.dao.CustomerDao;
import com.jaremo.freedom_talk.customer.dao.NoteDao;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.NoteService;
import com.jaremo.freedom_talk.utils.RedisUtil;
import com.jaremo.freedom_talk.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @描述: 帖子服务层的实现类
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:55
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean insertNote(Note note, String customer_id) {

        Customer customer = customerDao.findCustomerById(customer_id);
        if(customer.getIsBm()==1 && customer.getType() == 2){ // 证明该客户是版主
            String noteTime = TimeUtil.dateToString(new Date(), 1);
            note.setTime(noteTime);
            note.setCustomer(customer);

            noteDao.addNote(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNote(Note note) {
        if(note!=null){
            noteDao.editNote(note);
            return true;
        }
        return false;
    }

    @Override
    public List<Note> selectAllByCondition(Note note) {
//        if(note.getTitle()!=null){ // 客户在搜索帖子的时候(根据标题模糊搜索)
//            List<Note> noteList = new ArrayList<>(); // 临时建立一个集合
//
//            Set<Object> notes = redisUtil.sGet("noteList"); // 当用户进行模糊搜索时,这时调用redis
//            if(notes!=null){
//                for(Object obj:notes){
//                    Note tempNote = (Note) obj;
//                    if(tempNote.getTitle().contains(note.getTitle())){
//                        noteList.add(tempNote);
//                    }
//                }
//                return noteList;
//            }else{
//                Note tempNote = new Note();
//                redisUtil.sSet("noteList",noteDao.findAllByCondition(tempNote));
//            }
//        }
        List<Note> notes = noteDao.findAllByCondition(note);
        return notes;
    }
}

