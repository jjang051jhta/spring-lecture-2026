package com.jjang051.tododb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    private int no;
    private String content;
    private String complete;
}
