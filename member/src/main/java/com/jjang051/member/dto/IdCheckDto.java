package com.jjang051.member.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdCheckDto {
    private String userId;
    private String userPw;
}
