package com.jjang051.sns.comment.dto;

import com.jjang051.sns.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponseDto {
    private Long id;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    public static CommentResponseDto from(Comment comment) {
        return CommentResponseDto.builder()
                                 .id(comment.getId())
                                 .content(comment.getContent())
                                 .writer(comment.getWriter())
                                 .createdAt(comment.getCreatedAt()).build();
    }
}
