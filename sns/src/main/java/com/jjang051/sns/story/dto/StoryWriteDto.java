package com.jjang051.sns.story.dto;

import com.jjang051.sns.story.entity.Story;
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

    //image는 MultipartFile이고 db에 저장할때 url을 저장해야 한다.
    public Story toEntity(String imageUrl) {
        return Story.builder()
                .writer(writer)
                .content(content)
                .image(imageUrl)
                .build();
    }
}
