package com.jaremo.freedom_talk.customer.controller;

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
 * @描述: 观点类控制层
 * @Author: pyj
 * @DateTime: 2018/11/6 0006--下午 2:15
 */
@Controller
public class ViewPointController {

    @Autowired
    private ViewPointService viewPointService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/lendvp.do",method = RequestMethod.POST)
    @ResponseBody
    public void lendViewPoint(Integer note_id,String cus_id,ViewPoint viewPoint){
        Note note = new Note();
        note.setId(note_id);

        Customer customer = new Customer();
        customer.setId(cus_id);

        viewPoint.setNote(note);
        viewPoint.setCustomer(customer);

        viewPointService.insertViewPoint(viewPoint);
    }

    @RequestMapping("/deletevp.do")
    public void delViewPoint(){
        Customer customer = new Customer();
        customer.setId("c");

        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setId(1);
        viewPoint.setCustomer(customer);

        viewPointService.deleteViewPoint(viewPoint);
    }

    @RequestMapping("/queryvp.do")
    public void queryViewPoint(){
        Note note = new Note();
        note.setId(2);

        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setNote(note);
        viewPoint.setIsDelete(1);

        List<ViewPoint> viewPointList = viewPointService.selectAllByCondition(viewPoint);
        System.out.println(viewPointList);
    }

    @RequestMapping("/gotoVp.do")
    public String gotoVp(Integer noteid, String fromid, ModelMap modelMap){
        Note note = new Note();
        note.setId(noteid);

        List<Note> noteList = noteService.selectAllByCondition(note);

        Customer customer = new Customer();
        customer.setId(fromid);

        List<Customer> customers = customerService.selectAllByCondition(customer);

        modelMap.addAttribute("note",noteList.get(0));
        modelMap.addAttribute("now_customer",customers.get(0));

        return "view_point";
    }
}
