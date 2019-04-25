package com.demo.springmailsender.service;

import com.demo.springmailsender.domain.EmailRequest;
import org.springframework.mail.MailException;

import java.io.UnsupportedEncodingException;

/**
 * @author yzd
 */
public interface EmailService {
    void sendEmail(EmailRequest emailRequest) throws MailException, UnsupportedEncodingException;
}
