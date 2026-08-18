package com.jjang051.sns.story.repository;


import com.jjang051.sns.story.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepsitory extends JpaRepository<Story, Long> {
    //기본 crud 만들어짐
    //jpa가 알아서 만들어 준다.
    //proxy
    //query method
    List<Story> findAllByOrderByIdDesc();

    List<Story> findAllByWriter(String writer);
}
