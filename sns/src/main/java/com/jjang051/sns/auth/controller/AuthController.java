package com.jjang051.sns.auth.controller;

import com.jjang051.sns.auth.dto.LoginDto;
import com.jjang051.sns.auth.dto.LoginResponseDto;
import com.jjang051.sns.auth.dto.MeResponseDto;
import com.jjang051.sns.auth.jwt.JwtProvider;
import com.jjang051.sns.auth.service.AuthService;
import com.jjang051.sns.global.dto.ApiResponseDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<LoginResponseDto>> login(@RequestBody LoginDto loginDto) {
        log.info("login");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUserId(), loginDto.getUserPassword())
            );

            String accessToken = jwtProvider.createAccessToken(authentication.getName());
            LoginResponseDto loginResponseDto = new LoginResponseDto(accessToken);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(
                            new ApiResponseDto<>(200, "login success", loginResponseDto)
                    );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(
                            new ApiResponseDto<>(401, "아이디 또는 비밀번호가 맞지 않습니다.", null)
                    );
        }
    }
    @GetMapping("/me")
    public ResponseEntity<ApiResponseDto<MeResponseDto>> getMe(Authentication authentication) {
        log.info("mememmme");
        String userId = authentication.getName();
        MeResponseDto meResponseDto = authService.getMe(userId);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(new ApiResponseDto<>(200,"me success", meResponseDto)
        );
    }
}
