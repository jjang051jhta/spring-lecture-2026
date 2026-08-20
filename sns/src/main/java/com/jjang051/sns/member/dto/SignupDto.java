package com.jjang051.sns.member.dto;

import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.entity.Role;
import com.jjang051.sns.story.entity.Story;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDto {
    private String userId;
    private String userPassword;
    private String userName;
    private Role role;
    private MultipartFile profile;

    public Member toEntity(String imageUrl, String encodedPassword) {
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .userPassword(encodedPassword)
                .profile(imageUrl)
                .role(Role.USER)
                .build();
    }
}
