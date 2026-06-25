package com.jjang051.security.member.dao;

import com.jjang051.security.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
    int write(BoardDto boardDto);
}
