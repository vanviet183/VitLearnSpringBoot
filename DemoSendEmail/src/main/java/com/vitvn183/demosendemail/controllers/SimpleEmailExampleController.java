package com.vitvn183.demosendemail.controllers;

import com.vitvn183.demosendemail.base.MailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleEmailExampleController {
    @Autowired
    public JavaMailSender mailSender;

    @ResponseBody
    @GetMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MailConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, I'm testing Simple Email");

        // Send message
        this.mailSender.send(message);

        return "Email Sent";

    }
}
