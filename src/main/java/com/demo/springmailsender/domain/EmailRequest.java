package com.demo.springmailsender.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author yzd
 */
public class EmailRequest {

    @ApiModelProperty(value="收件人地址")
    private String address;

    @ApiModelProperty(value="主题")
    private String subject;

    @ApiModelProperty(value="正文")
    private String msg;

    @ApiModelProperty(value="发件人姓名")
    private String from;

    @ApiModelProperty(value="收件人姓名")
    private String to;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}