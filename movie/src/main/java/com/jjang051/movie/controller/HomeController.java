package com.jjang051.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //int nums[] = {1,2,3};
    @GetMapping({"/","/index","/home","/main"})
    public String home() {
        return "redirect:/movie/list";
    }
}
