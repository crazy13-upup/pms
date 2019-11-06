package com.yjiuye.sys.controller;

import com.yjiuye.cust.bean.Customer;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.sys.bean.Sources;
import com.yjiuye.sys.service.EmployeeService;
import com.yjiuye.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SourcesService sourcesService;

    //获取(除去当前用户)其他用户的信息，包括邮箱
    @RequestMapping(value = "/getEmployee",method = RequestMethod.POST)
    @ResponseBody
    public List<Employee> getEmployee(HttpSession session){
       Employee employee = (Employee) session.getAttribute("user");
        Integer eid = employee.getEid();
        List<Employee> list =  employeeService.getEmployee(eid);
        return list;
    }

    //登出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }

     //登陆
    @RequestMapping("/login")
    public String login(Employee employee, String code, HttpSession session, RedirectAttributes redirectAttributes){
        //判断存在域中的验证码和输入的验证码
       String validateCode = (String) session.getAttribute("validateCode");
        if( validateCode.equalsIgnoreCase(code)){
            //两者相等立马销毁域中的code
            session.removeAttribute("validateCode");
            //再来判断用户名和密码是否正确
         Employee employee1 =  employeeService.selectEmp(employee);
            if(employee1 == null){
                redirectAttributes.addFlashAttribute("errorMsg","用户名或者密码错误");
                return "redirect:/login";
            }else{

                session.setAttribute("user",employee1);
                return "redirect:/index.jsp";
            }
        }else{
            redirectAttributes.addFlashAttribute("errorMsg","验证码输入错误");
            return "redirect:/login";
        }

    }

    //异步请求获取所有经理的信息
    @RequestMapping("/list")
    @ResponseBody
    public List<Employee> getEmployeeList(){
       List<Employee> list =  employeeService.getEmployeeList();
       return list;
    }
}
