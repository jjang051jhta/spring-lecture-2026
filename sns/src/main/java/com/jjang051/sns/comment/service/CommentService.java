package com.jjang051.sns.comment.service;

import com.jjang051.sns.comment.dto.CommentResponseDto;
import com.jjang051.sns.comment.dto.CommentWriteDto;
import com.jjang051.sns.comment.entity.Comment;
import com.jjang051.sns.comment.repository.CommentRepository;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import com.jjang051.sns.story.entity.Story;
import com.jjang051.sns.story.repository.StoryRepsitory;
import com.jjang051.sns.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final StoryRepsitory storyRepsitory;

    @Transactional
    public CommentResponseDto saveComment(Long storyId,
                                          String userId,
                                          CommentWriteDto commentWriteDto) {
        Story story = storyRepsitory.findById(storyId).orElseThrow(()->new RuntimeException("Story not found"));
        Member member = memberRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("Member not found"));
        Comment comment =  Comment.builder()
                .story(story)
                .content(commentWriteDto.getContent())
                .writer(member.getUserId())
                .build();
        Comment saveComment = commentRepository.save(comment);
        return CommentResponseDto.from(saveComment);
    }

    public List<CommentResponseDto> getComments(Long storyId) {
        return commentRepository.findByStoryIdOrderByIdAsc(storyId)
                                .stream()
                                .map(CommentResponseDto::from)
                                .toList();
    }
}
