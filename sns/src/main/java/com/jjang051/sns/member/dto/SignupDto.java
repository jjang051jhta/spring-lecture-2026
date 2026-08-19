package com.jjang051.sns.member.dto;

import com.jjang051.sns.member.entity.Member;
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
    private MultipartFile profile;

    public Member toEntity(String imageUrl) {
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .userPassword(userPassword)
                .profile(imageUrl)
                .build();
    }

}
