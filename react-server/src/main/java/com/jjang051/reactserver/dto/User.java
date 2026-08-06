package com.jjang051.reactserver.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private int age;
    private String major;
}
