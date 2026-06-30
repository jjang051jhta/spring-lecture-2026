package com.jjang051.security.member.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails, OAuth2User {
    private final MemberDto memberDto;
    private Map<String, Object> oauth2UserInfo;

    public CustomUserDetails(MemberDto memberDto) {
        this.memberDto = memberDto;
    }
    public CustomUserDetails(MemberDto memberDto,Map<String, Object> oauth2UserInfo ) {
        this.memberDto = memberDto;
        this.oauth2UserInfo = oauth2UserInfo;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }
    @Override
    public String getName() {
        return oauth2UserInfo.get("name").toString();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(memberDto.getRole().name())
        );
    }

    @Override
    public @Nullable String getPassword() {
        return memberDto.getUserPw();
    }

    @Override
    public String getUsername() {
        return memberDto.getUserId();
    }


}
