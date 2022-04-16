package com.vitvn183.demosendemail.controllers;

import com.vitvn183.demosendemail.base.MailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class HtmlEmailExampleController {
    @Autowired
    public JavaMailSender mailSender;

    @ResponseBody
    @GetMapping("/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo(MailConstants.FRIEND_EMAIL);

        helper.setSubject("Test send HTML email");


        this.mailSender.send(message);

        return "Email Sent!";
    }
}
