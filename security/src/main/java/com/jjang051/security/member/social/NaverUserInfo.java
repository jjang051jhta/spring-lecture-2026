package com.jjang051.security.member.social;

import java.util.Map;
public class NaverUserInfo implements SocialUserInfo {
    private final Map<String,Object> attributes;
    private final Map<String,Object> response;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.response = (Map<String,Object>)attributes.get("response");
    }

    @Override
    public String getName() {
        return response.get("name").toString();
    }
    @Override
    public String getEmail() {
        return (String) response.get("email");
    }
    @Override
    public String getProvider() {
        return "naver";
    }
    @Override
    public String getProviderID() {
        return getProvider()+"_"+response.get("id").toString();
    }
}
