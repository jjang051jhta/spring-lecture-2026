package com.jjang051.sns.story.repository;


import com.jjang051.sns.story.entity.Story;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryRepsitory extends JpaRepository<Story, Long> {
    //기본 crud 만들어짐
    //jpa가 알아서 만들어 준다.
    //proxy
    //query method
    List<Story> findAllByOrderByIdDesc(); //jpa는 구현이 없다.  스프링이 proxy를 만들어서 주입해 준다.
    //Page<Story> findAllByOrderByIdDesc(Pageable pageable);
    Slice<Story> findAllByOrderByIdDesc(Pageable pageable);

    //querydsl
    //Story는 entity이다. 대소문자 잘 맞춰서 써야 한다.
    //jpql
    //@Query(value="SELECT * FROM Story s ORDER BY id DESC", nativeQuery = true)
    @Query("SELECT s FROM Story s ORDER BY s.id DESC")
    List<Story> customFindAllByOrderByIdDesc();

    List<Story> findAllByWriter(String writer);

    @Query("SELECT s FROM Story s WHERE s.writer = :writer")
    List<Story> customFindAllByWriter(@Param("writer") String writer);
}
