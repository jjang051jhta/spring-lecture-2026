package com.jjang051.sns.auth.service;

import com.jjang051.sns.auth.dto.LoginDto;
import com.jjang051.sns.auth.dto.MeResponseDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    public MeResponseDto getMe(String userId) {
        Member findedMember = memberRepository.findByUserId(userId)
                              .orElseThrow(()->new RuntimeException("사용자를 찾을 수 없습니다"));
        return new MeResponseDto(findedMember.getUserId(),
                                 findedMember.getUserName(),
                                 findedMember.getProfile());
    }
}
