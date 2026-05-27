package com.jjang051.todo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
    private String content;
    private boolean complete;
}
