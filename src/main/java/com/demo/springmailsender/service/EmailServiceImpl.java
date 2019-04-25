package com.demo.springmailsender.service;

import com.demo.springmailsender.domain.EmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromAddress;


    @Override
    public void sendEmail(EmailRequest emailRequest) throws MailException, UnsupportedEncodingException {
        Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String fromByte = new String((emailRequest.getFrom() + " <" + fromAddress + ">")
                .getBytes("UTF-8"));
        String toByte = new String((emailRequest.getTo() + " <" + emailRequest.getAddress() + ">")
                .getBytes("UTF-8"));
        simpleMailMessage.setFrom(fromByte);
        simpleMailMessage.setTo(toByte);
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getMsg());
        logger.info("Email alert: from:{}, to: {}, to address: {}, subject: {}, text: {}",
                emailRequest.getFrom(), emailRequest.getTo(), emailRequest.getAddress(),
                emailRequest.getSubject(), emailRequest.getMsg());
        javaMailSender.send(simpleMailMessage);
    }
}