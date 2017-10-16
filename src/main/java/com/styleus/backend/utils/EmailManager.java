package com.styleus.backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {
    private final static String FROM = "styleusintec@outlook.com";
    private final static String PASSWORD = "StyleUs1410";
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailManager(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public EmailManager() {
    }

    public void sendEmail(String toEmail, String subject, String message) throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(FROM);
        javaMailSender.send(mailMessage);
    }

}

