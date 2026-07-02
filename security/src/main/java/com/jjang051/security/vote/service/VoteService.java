package com.jjang051.security.vote.service;

import com.jjang051.security.vote.dao.VoteDao;
import com.jjang051.security.vote.dto.VoteDto;
import com.jjang051.security.vote.dto.VoteItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoteService {
    private final VoteDao voteDao;
    public List<VoteDto> findAllVotes() {
        return voteDao.findAllVotes();
    }
    public VoteDto findVote(int voteNo) {
        VoteDto voteDto = voteDao.findVoteByNo(voteNo); //title 월드컵 우승 후보는?
        voteDto.setItems(findItemsByVoteNo(voteNo)); //브라질,프랑스,영국,아르헨티나
        return voteDto;
    }
    public List<VoteItemDto> findItemsByVoteNo(int voteNo) {
        return voteDao.findItemsByVoteNo(voteNo);
    }
    public Integer increaseVoteCount(int itemNo) {
        return voteDao.increaseVoteCount(itemNo);
    }

    public void createVote(String title, List<String> itemTexts) {
        VoteDto voteDto = new VoteDto();
        voteDto.setTitle(title);
        voteDao.insertVote(voteDto);
        log.info("voteDto.getVoteNo() == {}",voteDto.getVoteNo());
        for(String itemText: itemTexts){
            voteDao.insertVoteItem(voteDto.getVoteNo(),itemText);
        }
    }
}
