package com.jjang051.security.chart.service;

import com.jjang051.security.chart.dao.ChartDao;
import com.jjang051.security.chart.dto.ChartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartService {
    private final ChartDao chartDao;
    public List<ChartDto> findChinaMenu() {
        return chartDao.findChinaMenu();
    }
}
