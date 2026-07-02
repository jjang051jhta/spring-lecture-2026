package com.jjang051.security.vote.dao;

import com.jjang051.security.vote.dto.VoteDto;
import com.jjang051.security.vote.dto.VoteItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoteDao {
    List<VoteDto> findAllVotes();
    List<VoteItemDto> findItemsByVoteNo(int voteNo);
    VoteDto findVoteByNo(int voteNo);
    Integer increaseVoteCount(int itemNo);
    void insertVote(VoteDto voteDto);
    void insertVoteItem(@Param("voteNo") int voteNo,
                        @Param("itemText") String itemText);
}
