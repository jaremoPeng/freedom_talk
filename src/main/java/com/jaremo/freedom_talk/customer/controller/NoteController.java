package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.background.domain.Category;
import com.jaremo.freedom_talk.background.service.CategoryService;
import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.service.CustomerService;
import com.jaremo.freedom_talk.customer.service.NoteService;
import com.jaremo.freedom_talk.customer.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ViewPointService viewPointService;

    @RequestMapping(value = "/lendNote.do",method = RequestMethod.POST)
    @ResponseBody
    public void lendNote(String cusid,Note note,Integer category_id){
        Category category = new Category();
        category.setId(category_id);

        note.setCategory(category);
        // 帖子的图片功能尚未完成

        boolean result = noteService.insertNote(note, cusid);

        if(result){
            System.out.println("添加帖子成功");
        }else{
            System.out.println("添加帖子失败");
        }
    }

    @RequestMapping(value = "/delNote.do",method = RequestMethod.POST)
    @ResponseBody
    public String delNote(Integer noteid){
        Note note = new Note();
        note.setId(noteid);
        note.setIsDelete(0);

        boolean result = noteService.updateNote(note);
        if(result){
            return "";
        }
        return "failed";
    }

    @RequestMapping("/editNote.do")
    public void editNote(){
        Note note = new Note();
        note.setId(3);
        note.setBrowserNum(200);
        note.setCommentNum(300);

        noteService.updateNote(note);
    }

    @RequestMapping(value = "/gotoNoteList.do")
    public String gotoNoteList(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);
        Note note = new Note();
        note.setCustomer(tempCustomer);
        note.setIsDelete(1);

        List<Note> noteList = noteService.selectAllByCondition(note);
        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("noteList",noteList);
        return "note_list";
    }

    @RequestMapping(value = "/gotoNoteAdd.do")
    public String gotoNoteAdd(String cus_id,ModelMap modelMap) { // 做一个中转
        Customer tempCustomer = new Customer();
        tempCustomer.setId(cus_id);

        Category category = new Category();
        List<Category> categoryList = categoryService.selectAllByCondition(category);

        List<Customer> customers = customerService.selectAllByCondition(tempCustomer);
        modelMap.addAttribute("now_customer",customers.get(0));
        modelMap.addAttribute("categoryList",categoryList);
        return "note_add";
    }


    @RequestMapping(value = "/gotoNoteDetail.do")
    public String gotoNoteDetail(Integer note_id,ModelMap modelMap) { // 做一个中转
        Note note = new Note();
        note.setId(note_id);

        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setNote(note);
        List<ViewPoint> viewPointList = viewPointService.selectAllByCondition(viewPoint);

        List<Note> noteList = noteService.selectAllByCondition(note);
        modelMap.addAttribute("note",noteList.get(0));
        modelMap.addAttribute("viewPointList",viewPointList);
        return "note_detail";
    }
}
