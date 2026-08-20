package com.jjang051.sns.auth.service;

import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member findedMember = memberRepository.findByUserId(userId).orElseThrow(
                () -> new UsernameNotFoundException("사용자를 찾을 수 없습니다.")
        );
        return User.builder()
                .username(findedMember.getUserId())
                .password(findedMember.getUserPassword())
                .roles("USER")
                .build();
    }
}
