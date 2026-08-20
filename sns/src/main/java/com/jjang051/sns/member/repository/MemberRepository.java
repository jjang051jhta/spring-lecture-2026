package com.jjang051.sns.member.repository;

import com.jjang051.sns.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //query method
    boolean existsByUserId(String userid);
    Optional<Member> findByUserId(String userId);

}
