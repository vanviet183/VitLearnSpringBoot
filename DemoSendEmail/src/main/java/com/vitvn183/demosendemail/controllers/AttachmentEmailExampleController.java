package com.vitvn183.demosendemail.controllers;

import com.vitvn183.demosendemail.base.MailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
public class AttachmentEmailExampleController {
    @Autowired
    public JavaMailSender mailSender;

    @ResponseBody
    @GetMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MailConstants.FRIEND_EMAIL);
        helper.setSubject("Test email with attachments");

        helper.setText("Hello, Im testing email with attachments!");

        String path1 = "/E:\\Self_Learning\\DemoSendEmail/test.txt";
        String path2 = "/E:\\Self_Learning\\DemoSendEmail/test.docx";

        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);

        // Attachment 2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("Readme", file2);

        mailSender.send(message);

        return "Email Sent!";
    }
}
