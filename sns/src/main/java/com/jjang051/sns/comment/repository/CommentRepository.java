package com.jjang051.sns.comment.repository;

import com.jjang051.sns.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
