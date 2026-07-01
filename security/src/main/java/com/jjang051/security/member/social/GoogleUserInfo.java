package com.jjang051.security.member.social;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class GoogleUserInfo implements SocialUserInfo {
    private final Map<String,Object> attributes;
    @Override
    public String getName() {
        return attributes.get("name").toString();
    }

    @Override
    public String getEmail() {
        return attributes.get("email").toString();
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getProviderID() {
        return getProvider()+"_"+attributes.get("sub").toString();
    }
}
