package online.zhaopei.myproject.service.impl;

import online.zhaopei.myproject.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.Console;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendMail() {
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("344501823@qq.com");
            message.setTo("344501823@qq.com");
            message.setSubject("测试邮件主题");
            message.setText("测试邮件内容");
            this.mailSender.send(mimeMessage);
        }
        catch(Exception ex)
        {
        }
    }
}
