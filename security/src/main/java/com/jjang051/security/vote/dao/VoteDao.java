package com.jjang051.security.vote.dao;

import com.jjang051.security.vote.dto.VoteDto;
import com.jjang051.security.vote.dto.VoteItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteDao {
    List<VoteDto> findAllVotes();
    List<VoteItemDto> findItemsByVoteNo(int voteNo);
    VoteDto findVoteByNo(int voteNo);
}
