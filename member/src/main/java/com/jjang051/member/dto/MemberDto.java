package com.jjang051.member.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private int no;

    private String userId;      // 회원아이디

    private String userName;    // 이름

    private String userPw;      // 비밀번호

    private String email;       // 이메일

    private String phone;       // 전화번호

    private String address;     // 주소

    private LocalDateTime regDate; // 가입일
}