package com.jjang051.movie.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MovieDto {
    private int no;
    private String title;
    private String reserveYn;
}
