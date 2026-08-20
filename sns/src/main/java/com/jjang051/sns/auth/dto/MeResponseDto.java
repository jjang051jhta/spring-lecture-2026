package com.jjang051.sns.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeResponseDto {
    private String userId;
    private String userName;
    private String profile;
}
