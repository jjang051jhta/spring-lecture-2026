package com.jjang051.sns.member.controller;

import com.jjang051.sns.auth.dto.MeResponseDto;
import com.jjang051.sns.global.dto.ApiResponseDto;
import com.jjang051.sns.member.dto.MemberUpdateDto;
import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @PutMapping("/me")
    public ResponseEntity<ApiResponseDto<MeResponseDto>> updateMember(
            @ModelAttribute MemberUpdateDto memberUpdateDto, Authentication authentication) {

            String userId = authentication.getName();
            log.info("memberUpdateDto={}", memberUpdateDto.toString());
            Member member = memberService.updateMember(userId,memberUpdateDto);
            MeResponseDto meResponseDto = MeResponseDto.from(member);
            log.info("memberUpdateDto02={}", memberUpdateDto.toString());
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new ApiResponseDto<>(200,"회원정보가 수정되었습니다.", meResponseDto));
    }
}
