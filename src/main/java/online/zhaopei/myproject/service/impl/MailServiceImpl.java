package online.zhaopei.myproject.service.impl;

import online.zhaopei.myproject.domain.ArchiveRecord;
import online.zhaopei.myproject.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.from}")
    private String from;
    @Value("${spring.mail.to}")
    private String to;
    @Value("${spring.mail.subject}")
    private String subject;
    @Value(" %s 于 %s 请求借阅档案，档案号为%s")
    private String format;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendMail(ArchiveRecord record) {
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(createContent(record));
            this.mailSender.send(mimeMessage);
        }
        catch(Exception ex)
        {
        }
    }

    private String createContent(ArchiveRecord record) {
        String user = record.getUser();
        String archiveNum = record.getArchiveNum();
        Date refDate = record.getReferdate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String content =  String.format(format, user, df.format(refDate), archiveNum );
        return content;
    }
}
