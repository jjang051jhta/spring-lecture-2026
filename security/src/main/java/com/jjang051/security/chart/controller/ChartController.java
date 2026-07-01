package com.jjang051.security.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    @GetMapping("/chart01")
    public String chart01() {
        return "chart/chart01";
    }
}
