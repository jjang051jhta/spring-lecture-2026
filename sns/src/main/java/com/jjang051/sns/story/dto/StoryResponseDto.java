package com.jjang051.sns.story.dto;

import com.jjang051.sns.story.entity.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoryResponseDto {
    private Long id;
    private String writer;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;
    public static StoryResponseDto from(Story story) {
        return StoryResponseDto.builder()
                .id(story.getId())
                .writer(story.getWriter())
                .content(story.getContent())
                .imageUrl(story.getImage())
                .build();
    }
}
