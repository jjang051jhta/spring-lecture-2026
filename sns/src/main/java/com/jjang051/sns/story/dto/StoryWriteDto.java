package com.jjang051.sns.story.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class StoryWriteDto {
    private String writer;
    private String content;
    public MultipartFile image;
}
