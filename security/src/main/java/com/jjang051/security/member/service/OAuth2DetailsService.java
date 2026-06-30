package com.jjang051.security.member.service;

import com.jjang051.security.member.dao.MemberDao;
import com.jjang051.security.member.dto.CustomUserDetails;
import com.jjang051.security.member.dto.MemberDto;
import com.jjang051.security.member.dto.SignupDto;
import com.jjang051.security.member.social.KakaoUserInfo;
import com.jjang051.security.member.social.SocialUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuth2DetailsService extends DefaultOAuth2UserService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("소셜로그인시도하면 여기로 들어온다.");
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("userRequest = {}", userRequest);
        Map<String,Object> oauth2UserInfo = (Map)oAuth2User.getAttributes();
        log.info("oauth2UserInfo = {}", oauth2UserInfo);
        //처음 로그인 시도한 경우 회원가입을 시키면서 로그인 처리
        //두번째 로그인 시도한 경우  db에 찾아서 있으면 자동 로그인 없으면 회원가입
        SocialUserInfo socialUserInfo = null;
        String provider =  userRequest.getClientRegistration().getRegistrationId();
        log.info("provider = {}", provider);
        if(provider.equals("kakao")) {
            socialUserInfo = new KakaoUserInfo(oauth2UserInfo);
        }
        String userId =  socialUserInfo.getProviderID();  //"kakao_1212123"
        MemberDto findMemberDto = memberDao.findByUserId(userId);
        if(findMemberDto == null) {
            SignupDto newMemberDto = SignupDto.builder()
                    .userId(userId)
                    .userPw(passwordEncoder.encode(UUID.randomUUID().toString()))
                    .userName(socialUserInfo.getName())
                    .userEmail(socialUserInfo.getEmail())
                    .build();
            memberDao.signup(newMemberDto);
            findMemberDto = memberDao.findByUserId(userId);
        }
        return new CustomUserDetails(findMemberDto,oAuth2User.getAttributes());
        //회원가입
    }
}
