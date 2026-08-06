package com.jjang051.reactmember.member.controller;

import com.jjang051.reactmember.member.dto.MemberDto;
import com.jjang051.reactmember.member.entity.Member;
import com.jjang051.reactmember.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:5173")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    @ResponseBody
    public String signup() {
        return "member save";
    }
    @PostMapping("/signup")
    @ResponseBody
    public String signupProcess(@RequestBody MemberDto memberDto) {
        memberService.saveMember(memberDto);
        return "ok";
    }

}
