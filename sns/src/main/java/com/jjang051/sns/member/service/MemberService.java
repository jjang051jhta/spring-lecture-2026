package com.jjang051.sns.member.service;

import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member signUp(SignupDto signupDto) {
        Member member = signupDto.toEntity("image");
        return memberRepository.save(member);
    }
}
