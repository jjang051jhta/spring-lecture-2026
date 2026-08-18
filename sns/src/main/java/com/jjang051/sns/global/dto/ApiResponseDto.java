package com.jjang051.sns.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//api서버 응답 전용 객체
@Getter
@AllArgsConstructor
public class ApiResponseDto<T> {
    private int status;
    private String message;
    private T data;
}
