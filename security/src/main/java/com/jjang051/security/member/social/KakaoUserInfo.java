package com.jjang051.security.member.social;

import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@RequiredArgsConstructor
public class KakaoUserInfo implements SocialUserInfo {
    private final Map<String,Object> attributes;
    @Override
    public String getName() {
        Map<String,Object> properties = (Map)attributes.get("properties");
        return properties.get("nickname").toString();
    }
    @Override
    public String getEmail() {
        Map<String, Object> kakaoAccount =
                (Map<String, Object>) attributes.get("kakao_account");
        if (kakaoAccount == null) {
            return null;
        }
        return (String) kakaoAccount.getOrDefault("email", null);
    }
    @Override
    public String getProvider() {
        return "kakao";
    }
    @Override
    public String getProviderID() {
        return getProvider()+"_"+attributes.get("id").toString();
    }

}
