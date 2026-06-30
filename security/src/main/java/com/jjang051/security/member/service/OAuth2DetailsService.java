package com.jjang051.security.member.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class OAuth2DetailsService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("소셜로그인시도하면 여기로 들어온다.");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("userRequest = {}", userRequest);
        Map<String,Object> oauth2UserInfo = (Map)oAuth2User.getAttributes();
        log.info("oauth2UserInfo = {}", oauth2UserInfo);
        return super.loadUser(userRequest);
    }
}
