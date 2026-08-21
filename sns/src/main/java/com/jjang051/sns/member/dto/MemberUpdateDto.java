package com.jjang051.sns.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MemberUpdateDto {
    private String userName;
    private MultipartFile profile;
}
