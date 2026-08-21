package com.jjang051.sns.member.entity;

import com.jjang051.sns.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userPassword;

    private String profile;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateUserName(String userName) {
        this.userName = userName;
    }
    public void updateProfile(String userName,String profile) {
        this.userName = userName;
        if(profile!=null){
            this.profile = profile;
        }
    }
}
