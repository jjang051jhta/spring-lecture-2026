package com.jjang051.security.member.social;

public interface SocialUserInfo {
    String getName();
    String getEmail();
    String getProvider();  //kakao,google,naver
    String getProviderID();
}
