package com.jjang051.reactmember.member.service;


import com.jjang051.reactmember.member.dto.MemberDto;
import com.jjang051.reactmember.member.entity.Member;
import com.jjang051.reactmember.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public Member saveMember(MemberDto memberDto) {
        Member member = Member.builder()
                .userId(memberDto.getUserId())
                .userName(memberDto.getUserName())
                .userPw(memberDto.getUserPw())
                .build();
        return memberRepository.save(member);
    }
}
