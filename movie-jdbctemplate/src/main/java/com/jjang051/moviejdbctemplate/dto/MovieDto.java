package com.jjang051.moviejdbctemplate.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieDto {
    private int no;
    private String title;
    private String reserveYn;
}
