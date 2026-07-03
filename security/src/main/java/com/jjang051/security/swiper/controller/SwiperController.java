package com.jjang051.security.swiper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swiper")
public class SwiperController {
    @GetMapping({"/","/main"})
    public String swiperMain(){
        return "swiper/main";
    }
    @GetMapping("/admin")
    public String swiperAdmin(){
        return "swiper/admin";
    }
}
