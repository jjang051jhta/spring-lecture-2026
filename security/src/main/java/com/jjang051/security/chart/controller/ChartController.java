package com.jjang051.security.chart.controller;

import com.jjang051.security.board.service.BoardService;
import com.jjang051.security.chart.dto.ChartDto;
import com.jjang051.security.chart.service.ChartService;
import com.jjang051.security.member.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chart")
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    @GetMapping("/chart01")
    public String chart01(Model model) {
//        model.addAttribute("labels", List.of("짜장면","짬뽕","탕수육","유산슬","유린기") );
//        model.addAttribute("data", List.of(10,15,17,8,12) );
//        model.addAttribute("type", "pie");
        List<ChartDto> chinaMenu = chartService.findChinaMenu();
        List<String> labels = chinaMenu
                                .stream()
                                .map(ChartDto::getLabel)
                                .toList();
        List<Integer> data = chinaMenu
                .stream()
                .map(ChartDto::getValue)
                .toList();

        model.addAttribute("type", "pie");
        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "chart/chart01";
    }
}
