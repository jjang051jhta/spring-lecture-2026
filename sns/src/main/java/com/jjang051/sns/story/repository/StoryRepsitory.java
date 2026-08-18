package com.jjang051.sns.story.repository;


import com.jjang051.sns.story.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepsitory extends JpaRepository<Story, Long> {
    //기본 crud 만들어짐
}
