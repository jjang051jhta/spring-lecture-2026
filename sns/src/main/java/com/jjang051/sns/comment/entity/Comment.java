package com.jjang051.sns.comment.entity;

import com.jjang051.sns.global.entity.BaseEntity;
import com.jjang051.sns.story.entity.Story;
import jakarta.persistence.*;
import lombok.*;

@Table(name="story_comment")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    private Long id;

    private String writer;

    //story를 조회할때 comment는 가지고 오지 않겠다.  lazy LOADING  story.getComments()
    //결국 fk를 가지고 있는 쪽이 연관관계의 주인이 된다.
    //ManyToOne쪽이 연관관계의 주인이 된다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @Column(nullable = false, length = 1000)
    private String content;
}
