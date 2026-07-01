package com.jjang051.security.chart.dao;

import com.jjang051.security.chart.dto.ChartDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartDao {
    List<ChartDto> findChinaMenu();
}
