package com.jjang051.sns.comment.controller;

import com.jjang051.sns.comment.dto.CommentResponseDto;
import com.jjang051.sns.comment.dto.CommentWriteDto;
import com.jjang051.sns.comment.service.CommentService;
import com.jjang051.sns.global.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stories")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/{storyId}/comments")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> addComment(@PathVariable Long storyId,
                                                                         @RequestBody CommentWriteDto commentWriteDto,
                                                                         Authentication authentication
                                                                         ){
        log.info("storyId==={}",storyId);
        log.info("CommentWriteDto==={}",commentWriteDto);
        log.info("authentication==={}",authentication);
        String userId = authentication.getName();
        CommentResponseDto commentResponseDto =
                commentService.saveComment(storyId,userId,commentWriteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto<>(201,"댓글이 등록되었습니다.", commentResponseDto));
    }
}
