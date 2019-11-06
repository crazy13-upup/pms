package com.yjiuye.usual.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.usual.bean.Baoxiao;
import com.yjiuye.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/baoxiao")
public class BaoXiaoController {
    @Autowired
    private BaoXiaoService baoXiaoService;

    //当前登陆用户的报销列表
    @RequestMapping("/list")
    public ModelAndView getBaoXiaoList(HttpServletRequest request,HttpSession session, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum){
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
        //登陆控制,这里获取的是
       Employee employee = (Employee) session.getAttribute("user");
       if(employee != null){
           Integer eid = employee.getEid();
           PageInfo<Baoxiao> page =  baoXiaoService.getBaoXiaoList(eid,pageNum,map);
           ModelAndView modelAndView = new ModelAndView("mybaoxiao-base");
           modelAndView.addObject("page",page);
           String str = parseMapToStringMap(map);
           modelAndView.addObject("str",str);
           String requestURI = request.getRequestURI();
           modelAndView.addObject("requestURI",requestURI);
           return modelAndView;
       }
       ModelAndView modelAndView = new ModelAndView("login");
       return modelAndView;
    }

    private String parseMapToStringMap(Map<String, Object> map) {
        String str  ="";
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry:entries) {
           String key = entry.getKey();
           String value = (String) entry.getValue();
           str = str +"&"+"search_"+key+"="+value;
        }
        return str;
    }


    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public String insertBaoXiao(Baoxiao baoxiao, HttpSession session, RedirectAttributes redirectAttributes){
        Employee employee  = (Employee) session.getAttribute("user");
        if(employee != null){
            Integer eid = employee.getEid();
            baoxiao.setEmpFk(eid);
            baoXiaoService.insertBaoXiao(baoxiao);
            return "redirect:/mybaoxiao-base.jsp";
        }
        //如果session中没有该对象，返回到登陆界面
        redirectAttributes.addFlashAttribute("errorMsg","当前没有用户登陆，请先登陆吧");
        return "redirect:/login";

    }
}
