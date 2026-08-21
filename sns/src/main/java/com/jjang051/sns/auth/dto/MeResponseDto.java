package com.jjang051.sns.auth.dto;

import com.jjang051.sns.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MeResponseDto {
    private String userId;
    private String userName;
    private String profile;

    public static MeResponseDto from(Member member){
        return MeResponseDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .profile(member.getProfile())
                .build();
    }
}
