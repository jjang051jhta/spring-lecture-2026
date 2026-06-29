package com.jjang051.security.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {
    @GetMapping("/map01")
    public String map01(Model model) {
        String address = "경기도 고양시 일산동구 중앙로1275번길 38-10";
        String placeName = "학원";
        model.addAttribute("address", address);
        model.addAttribute("placeName", placeName);
        return "map/map01";
    }
}
