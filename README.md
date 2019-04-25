# 前言

由于[价格监控项目](https://blog.csdn.net/qqxx6661/article/details/85301787)的需求，实现了一个小的邮件发送接口服务，使用了一个单独的SpringBoot项目，给他取名为spring-mail-sender，开源在了Github上。内部我给他命名为**提醒服务**，因为未来希望还能扩展下，用来做短信发送服务，或者安卓等推送服务的API。


# 简介

本项目使用springboot，采用web api的方式提供邮件，短信等服务的调用接口，目前仅支持邮件提醒。


邮件提醒特点：

- 本地配置文件设置邮件账户密码和smtp
- 使用post来调用发送邮件请求，post中使用json数据填充：发件人昵称，收件人昵称，收件人邮箱，主题，正文。
- 调用接口返回状态码定义：(1=正常，2=错误，3=未登录，4=自定义错误（直接抛出errorMes）)
- 发件人，收件人支持别名。

本项目待完成：

- [ ] 调用接口鉴权：防止无权限人员调用
- [ ] 调用接口频率限制：防止滥用接口
- [ ] 调用日志存储

欢迎小伙伴们提意见，共同开发。

项目结构如下：

```
├─main
│  ├─java
│  │  └─com
│  │      └─demo
│  │          └─springmailsender
│  │              │  SpringMailSenderApplication.java
│  │              │  SwaggerConfig.java
│  │              │
│  │              ├─domain
│  │              │      EmailRequest.java
│  │              │      ResponseData.java
│  │              │
│  │              ├─service
│  │              │      EmailService.java
│  │              │      EmailServiceImpl.java
│  │              │
│  │              └─web
│  │                      EmailController.java
│  │
│  └─resources
│          application.properties
│
└─test
    └─java
        └─com
            └─demo
                └─springmailsender
                        SpringMailSenderApplicationTests.java
```



# 关注我

我目前是一名后端开发工程师。技术领域主要关注后端开发，数据爬虫，数据安全，5G，物联网等方向。

微信：yangzd1102

Github：[@qqxx6661](https://github.com/qqxx6661)

个人博客：

- CSDN：[@qqxx6661](http://blog.csdn.net/qqxx6661)
- 知乎：[@Zhendong](https://www.zhihu.com/people/yang-zhen-dong-1/)
- 简书：[@蛮三刀把刀](https://www.jianshu.com/u/b5f225ca2376)
- 掘金：[@蛮三刀把刀](https://juejin.im/user/5b48015ce51d45191462ba55)

### 原创博客主要内容

- Java知识点复习全手册
- Leetcode算法题解析
- 剑指offer算法题解析
- SpringCloud菜鸟入门实战系列
- SpringBoot菜鸟入门实战系列
- Python爬虫相关技术文章
- 后端开发相关技术文章


### 个人公众号：Rude3Knife

![个人公众号：Rude3Knife](https://img-blog.csdnimg.cn/20190226163135670.png)

**如果文章对你有帮助，不妨收藏起来并转发给您的朋友们~**
