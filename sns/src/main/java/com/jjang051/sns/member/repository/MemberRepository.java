package com.jjang051.sns.member.repository;

import com.jjang051.sns.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByUserId(String userid);
    //find , exists
}
