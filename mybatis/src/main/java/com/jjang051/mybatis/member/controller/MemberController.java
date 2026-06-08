package com.jjang051.mybatis.member.controller;

import com.jjang051.mybatis.member.dto.MemberDto;
import com.jjang051.mybatis.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/signup")
    public String signup(){
        return "member/signup";
    }
    @PostMapping("/signup")
    @ResponseBody
    public String signupProcess(MemberDto memberDto){
        System.out.println(memberDto.toString());
        int result = memberService.signup(memberDto);
        if(result == 0){
            return "회원가입 실패";
        }
        return "회원가입 성공";
    }
    @PostMapping("/id-check")
    @ResponseBody
    public Map<String,Boolean> idCheck(String userId){
        int result = memberService.idCheck(userId);
        Map<String,Boolean> map = new HashMap<>();
        if(result == 0){
            map.put("isDuplicate",false);
        } else{
            map.put("isDuplicate",true);
        }
        return map;
    }
}
