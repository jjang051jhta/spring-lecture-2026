package com.jjang051.sns.story.controller;

import com.jjang051.sns.story.dto.StoryWriteDto;
import com.jjang051.sns.story.entity.Story;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/stories")
public class StoryController {

    //@CrossOrigin("http://localhost:5173")
    @PostMapping
    public String saveStory(@ModelAttribute StoryWriteDto storyWriteDto) {
        //writer,image,content
        log.info("StoryWriteDto: {}", storyWriteDto);
        return "story이 등록되었습니다.";
    }
}
