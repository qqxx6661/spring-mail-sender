package com.demo.springmailsender.web;

import com.demo.springmailsender.domain.EmailRequest;
import com.demo.springmailsender.service.EmailService;
import com.demo.springmailsender.domain.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @author yzd
 */
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @ApiOperation(value = "发送忘记密码邮件", notes = "发送忘记密码邮件")
    @RequestMapping(value = "/sendValidationEmail", method = {RequestMethod.POST})
    public ResponseData<String> sendValidationEmail(@RequestBody EmailRequest emailRequest){
        ResponseData<String> responseData = new ResponseData<>();
        try {
            emailService.sendEmail(emailRequest);
            responseData.jsonFill(1, null, null);
        } catch (MailException|UnsupportedEncodingException e) {
            responseData.jsonFill(2, e.getMessage(), null);
        }
        return responseData;
    }
}