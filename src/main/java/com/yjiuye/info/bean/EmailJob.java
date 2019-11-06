package com.yjiuye.info.bean;

import org.quartz.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取JobDataMap 在获取放在JobDataMap里面的数据，
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        Email email =(Email) mergedJobDataMap.get("email");
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl)mergedJobDataMap.get("javaMailSender");
        Scheduler sched =(Scheduler) mergedJobDataMap.get("sched");
        try{
            //邮件对象
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            helper.setFrom("lqc980123@163.com");
            helper.setTo(email.getEname());
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent());
            //发送邮件
            javaMailSender.send(mimeMessage);
            System.out.println("EMAIL PASS");
            //邮件发送完毕，将定时任务关闭
            sched.standby();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
