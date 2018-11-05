package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @描述: 帖子类的控制层
 * @Author: pyj
 * @DateTime: 2018/11/5 0005--下午 2:16
 */
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/lendNote.do")
    public void lendNote(){
        Note note = new Note();

        Category category = new Category();
        category.setId(2);

        note.setCategory(category);
        note.setContent("十年前，在那个优秀得分手井喷的年代，科比，艾弗森他们为我们上演了无数次得分盛宴，他们将个人英雄主义演绎到极致，一场场飙分大战即使到现在很多人也记忆犹新。而如今，他们已离开了NBA，而联盟也不再由得分后卫来接管，我们能欣赏到的高分盛宴越来越少，那么现役50分先生还有几人？且随我一同来看！");
        note.setTitle("【盘点现役50+分俱乐部成员】震惊，没想到他竟是50分先生！");

        boolean result = noteService.insertNote(note, "a");

        if(result){
            System.out.println("添加帖子成功");
        }else{
            System.out.println("添加帖子失败");
        }
    }

    @RequestMapping("/delNote.do")
    public void delNote(){
        Note note = new Note();
        note.setId(3);
        note.setIsDelete(0);

        noteService.updateNote(note);
    }
    @RequestMapping("/editNote.do")
    public void editNote(){
        Note note = new Note();
        note.setId(3);
        note.setBrowserNum(200);
        note.setCommentNum(300);

        noteService.updateNote(note);
    }
    @RequestMapping("/queryNote.do")
    public void queryNote(){
        Note note = new Note();
        note.setTitle("hello");
//        note.setId(3);

        List<Note> noteList = noteService.selectAllByCondition(note);
        System.out.println(noteList);
    }
}
