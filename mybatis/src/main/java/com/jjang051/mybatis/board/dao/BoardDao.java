package com.jjang051.mybatis.board.dao;

import com.jjang051.mybatis.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
    int writeBoard(BoardDto boardDto);
}
