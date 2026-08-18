package com.jjang051.sns.story.controller;

import com.jjang051.sns.story.entity.Story;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/stories")
public class StoryController {

    //@CrossOrigin("http://localhost:5173")
    @PostMapping
    public String saveStory(){
        return "story이 등록되었습니다.";
    }
}
