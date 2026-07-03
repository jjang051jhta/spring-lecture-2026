package com.jjang051.security.swiper.dao;

import com.jjang051.security.swiper.dto.MainSlideDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainSlideDao {
    void insertSlide(MainSlideDto mainSlideDto);
}
