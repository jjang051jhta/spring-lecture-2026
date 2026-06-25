package com.jjang051.security.board.service;

import com.jjang051.security.board.dto.BoardDto;
import com.jjang051.security.member.dao.BoardDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;
    public int write(BoardDto boardDto) {
        boardDto.setHit(0);
        boardDto.setRegDate(LocalDateTime.now());
        return boardDao.write(boardDto);
    }
}
