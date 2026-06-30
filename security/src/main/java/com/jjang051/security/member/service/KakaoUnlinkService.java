package com.jjang051.security.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoUnlinkService {
    private final RestClient restClient = RestClient.create();

    @Value("${kakao.admin-key}")
    private String adminKey;

    public void unlinkByAdminKey(String kakaoUserId){
        log.info("admin-key = {}",adminKey);
        restClient.post()
                .uri("https://kapi.kakao.com/v1/user/unlink")
                .header("Authorization", "KakaoAK "+adminKey)
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("target_id_type=user_id&target_id=" +kakaoUserId)
                .retrieve()
                .body(String.class);
    }
}
