package com.jjang051.sns.story.entity;

import com.jjang051.sns.comment.entity.Comment;
import com.jjang051.sns.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="story")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Story extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false,length = 3000)
    private String content;

    private String image;

    // mappedBy의 의미
    // 여기다가 컬럼을 만들지 마라.... 그리고 연관관계의 주인은 comment이다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "story")
    private List<Comment> comments;

//    @CreatedDate
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    /*
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
     */
}
