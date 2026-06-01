package com.jjang051.member.controller;

import com.jjang051.member.dto.MemberDto;
import com.jjang051.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/signup")
    public String signupProcess(@ModelAttribute MemberDto memberDto) {
        memberService.signup(memberDto);
        //System.out.println(memberDto.toString());
        return "redirect:/";
    }
}
