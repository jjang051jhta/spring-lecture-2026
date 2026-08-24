package com.jjang051.sns.comment.repository;

import com.jjang051.sns.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment>  findByStoryIdOrderByIdAsc(Long storyId);
}
