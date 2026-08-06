package com.jjang051.reactmember.member.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String userId;
    private String userName;
    private String userPw;
    private Integer id; //1,2,3,4
}
