package com.yjiuye.info.controller;

import com.yjiuye.info.service.TieZiService;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.usual.bean.Forumpost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/tz")
public class TieZiController {

    @Resource
    private TieZiService tieZiService;
    @RequestMapping(value = "/savaInfo",method = RequestMethod.POST)
    public String saveInfo(HttpSession session,Forumpost forumpost){
        Employee employee = (Employee) session.getAttribute("user");
        Integer eid = employee.getEid();
        forumpost.setEmpFk3(eid);
        forumpost.setCreatetime(new Date());
        forumpost.setStatus(0);
        tieZiService.saveInfo(forumpost);
        return "redirect:/main.jsp";

    }
}
