package com.jjang051.security.member.controller;

import com.jjang051.security.member.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    private final MailService mailService;
    @GetMapping("/test-mail")
    @ResponseBody
    public String testMail() {
        mailService.sendMail("jjang051@hanmail.net","테스트입니다.","내용 없습니다.");
        return "success";
    }
    @GetMapping("/test-html-mail")
    @ResponseBody
    public String testHtmlMail() {
        mailService.sendMailHtml("jjang051@hanmail.net","테스트입니다.","<h1>안녕하세요. html로 메일을 보냅니다.</h1>");
        return "success";
    }
    @GetMapping("/auth-member")
    @ResponseBody
    public String authMember() {
        mailService.sendAuthCode("jjang051@hanmail.net");
        return "success";
    }


}
