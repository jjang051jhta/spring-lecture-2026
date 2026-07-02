package com.jjang051.security.vote.service;

import com.jjang051.security.vote.dao.VoteDao;
import com.jjang051.security.vote.dto.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteDao voteDao;
    public List<VoteDto> findAllVotes() {
        return voteDao.findAllVotes();
    }
}
