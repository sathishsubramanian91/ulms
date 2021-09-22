package com.ulms.app.util.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendMail(SimpleMailMessage message){
        javaMailSender.send(message);
    }

}
