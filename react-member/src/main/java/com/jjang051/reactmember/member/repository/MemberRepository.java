package com.jjang051.reactmember.member.repository;

import com.jjang051.reactmember.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
