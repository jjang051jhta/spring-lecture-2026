package com.jjang051.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotBlank(message = "아이디는 필수입력 사항입니다.")
    private String userId;      // 회원아이디

    @NotBlank(message = "비밀번호는 필수입력 사항입니다.")
    private String userPw;
}
