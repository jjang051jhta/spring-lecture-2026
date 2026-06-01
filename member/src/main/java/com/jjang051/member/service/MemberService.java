package com.jjang051.member.service;

import com.jjang051.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JdbcTemplate jdbcTemplate;
    public void signup(MemberDto memberDto) {
        String sql = """
                INSERT INTO MEMBER VALUES
                (member_seq.nextval,?,?,
                ?,?,?,?,sysdate)
                """;
        jdbcTemplate.update(sql,
                memberDto.getUserId(),
                memberDto.getUserName(),
                memberDto.getUserPw(),
                memberDto.getEmail(),
                memberDto.getPhone(),
                memberDto.getAddress()
        );
    }
}
