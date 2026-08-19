package com.jjang051.sns.member.controller;

import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping("/check-userid")
    public Map<String,Boolean> checkUserid(@RequestParam("userId") String userId) {
        log.info("checkUserid={}", userId);
        Boolean exists = memberService.existsUserId(userId);
        return Map.of("available",!exists);
    }
}
