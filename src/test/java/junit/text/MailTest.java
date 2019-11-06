package junit.text;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class MailTest {

    @Test
    public  void test01() throws  Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-mail.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);

        //邮件对象
        MimeMessage mimeMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        helper.setFrom("lqc980123@163.com");
        helper.setTo("pengke1024@163.com");
        helper.setSubject("111111");
        helper.setText("11111");
        FileSystemResource fileSystemResource = new FileSystemResource(new File("d:\\i.jpg"));
        //以附件形式发送
        helper.addAttachment("girl.jpg",fileSystemResource);
        //内置资源发送，会显示在邮件正文内容中
        helper.addInline("girl.jpg",fileSystemResource);
        //发送邮件
        bean.send(mimeMessage);
        System.out.println("EMAIL PASS");
    }


}
