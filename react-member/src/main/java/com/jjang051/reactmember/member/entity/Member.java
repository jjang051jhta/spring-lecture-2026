package com.jjang051.reactmember.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MEMBER")
@Getter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String userId;

    private String userPw;

    private String userName;


}
