package com.jjang051.security.swiper.dao;

import com.jjang051.security.swiper.dto.MainSlideDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainSlideDao {
    void insertSlide(MainSlideDto mainSlideDto);
    List<MainSlideDto> findAllSlides();
}
