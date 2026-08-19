package com.jjang051.sns.member.controller;

import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private  final MemberService memberService;
    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupDto signupDto) {
        log.info("signupDto={}", signupDto);
        memberService.signUp(signupDto);
        return "success";
    }
}
