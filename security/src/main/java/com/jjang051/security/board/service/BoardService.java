package com.jjang051.security.board.service;

import com.jjang051.security.board.dto.BoardDto;
import com.jjang051.security.board.dao.BoardDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;
    public int write(BoardDto boardDto) {
        boardDto.setHit(0);
        boardDto.setRegDate(LocalDateTime.now());
        return boardDao.write(boardDto);
    }

    public List<BoardDto> findAll() {
        return boardDao.findAll();
    }
}
