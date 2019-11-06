package com.yjiuye.info.controller;

import com.yjiuye.info.bean.Email;
import com.yjiuye.info.bean.EmailJob;
import com.yjiuye.info.service.EmailService;
import com.yjiuye.sys.bean.Employee;
import com.yjiuye.sys.service.EmployeeService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/email")
public class EmailController {

    //注入发送邮件的
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Resource
    private EmailService emailService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo (HttpSession session,Email email) throws Exception{
       Employee employee =(Employee)session.getAttribute("user");
        Integer eid = employee.getEid();
        email.setEmpFk(eid);
        email.setSendtime(new Date());
        emailService.saveInfo(email);
        //创建JobDetail对象，指定对象的任务名称、组名
        JobDetail job = JobBuilder.newJob(EmailJob.class).build();
        //通过getJobDataMap方法
        JobDataMap jobDataMap = job.getJobDataMap();
        jobDataMap.put("email",email);
        jobDataMap.put("javaMailSender",javaMailSender);
        //获取当前时间
        Date startTime = new Date(System.currentTimeMillis());
        //创建SimpleTrigger对象，指定对象名称、组名  设置任务重复执行间隔时间，重复执行次数 启动时间
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().startAt(startTime).build();
        //创建任务管理器Scheduler对象
        Scheduler sched= StdSchedulerFactory.getDefaultScheduler();
        jobDataMap.put("sched",sched);
        //为Scheduler对象新增JOB以及对应的SimpleTrigger
        Date ft = sched.scheduleJob(job, trigger);
        sched.start();
        return "redirect:/message.jsp";
    }

}
