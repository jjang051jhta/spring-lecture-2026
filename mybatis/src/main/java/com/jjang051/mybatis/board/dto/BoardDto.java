package com.jjang051.mybatis.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int no;
    private String title;
    private String content;
    private int hit;
    private LocalDateTime regDate;

}
