package com.jjang051.sns.story.controller;

import com.jjang051.sns.global.dto.ApiResponseDto;
import com.jjang051.sns.story.dto.StoryResponseDto;
import com.jjang051.sns.story.dto.StoryWriteDto;
import com.jjang051.sns.story.entity.Story;
import com.jjang051.sns.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stories")
public class StoryController {
    private final StoryService storyService;
    /*
    @GetMapping
    public ResponseEntity<List<StoryResponseDto>> findAllStory() {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(storyService.findAllStory());
    }
     */
    @GetMapping
    public ResponseEntity<Page<StoryResponseDto>> findAllStory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(storyService.findAllStoryPage(page,size));
    }



    @PostMapping
    public ResponseEntity<ApiResponseDto<StoryResponseDto>> saveStory(@ModelAttribute StoryWriteDto storyWriteDto) {
        //writer,image,content
        log.info("StoryWriteDto: {}", storyWriteDto);
        StoryResponseDto storyResponseDto = storyService.saveStory(storyWriteDto);
        //객체 리턴하면 자동으로 json으로 변환이 된다.
        //ResponseEntity<String> response; //api서버만들때 응답전용 객체
        ApiResponseDto response = new ApiResponseDto<>(
                200,
                "success",
                storyResponseDto
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(response);
    }
}
