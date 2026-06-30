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
        //처음 로그인 시도한 경우 회원가입을 시키면서 로그인 처리
        //두번째 로그인 시도한 경우  db에 찾아서 있으면 자동 로그인 없으면 회원가입
        String provider =  userRequest.getClientRegistration().getRegistrationId();
        log.info("provider = {}", provider);



        return super.loadUser(userRequest);

        //회원가입
    }
}
