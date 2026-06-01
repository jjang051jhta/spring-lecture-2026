package com.jjang051.member.controller;

import com.jjang051.member.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/signup")
    public String signupProcess(@ModelAttribute MemberDto memberDto) {
        System.out.println(memberDto.toString());
        return "redirect:/";
    }
}
