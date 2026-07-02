package com.jjang051.security.vote.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vote")
public class VoteController {
    @GetMapping({"","/","/list"})
    public String list(Model model){
        return "vote/list";
    }
}
