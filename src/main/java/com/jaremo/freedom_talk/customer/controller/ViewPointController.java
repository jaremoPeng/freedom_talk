package com.jaremo.freedom_talk.customer.controller;

import com.jaremo.freedom_talk.customer.domain.Customer;
import com.jaremo.freedom_talk.customer.domain.Note;
import com.jaremo.freedom_talk.customer.domain.ViewPoint;
import com.jaremo.freedom_talk.customer.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/lendvp.do")
    public void lendViewPoint(){
        Note note = new Note();
        note.setId(2);

        Customer customer = new Customer();
        customer.setId("c");

        ViewPoint viewPoint = new ViewPoint();
        viewPoint.setNote(note);
        viewPoint.setContent("真是血的教训!!!");
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
}
