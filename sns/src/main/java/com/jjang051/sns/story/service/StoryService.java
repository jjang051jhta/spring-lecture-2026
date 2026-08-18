package com.jjang051.sns.story.service;

import com.jjang051.sns.story.dto.StoryWriteDto;
import com.jjang051.sns.story.entity.Story;
import com.jjang051.sns.story.repository.StoryRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepsitory storyRepsitory;
    public void saveStory(StoryWriteDto storyWriteDto) {
        //강한결합
        Story story = Story.builder()
                .writer(storyWriteDto.getWriter())
                .content(storyWriteDto.getContent())
                .image("이미지를 업로드하고 반환받는 이미지 경로")
                .build();
        storyRepsitory.save(story);
    }
}
