package com.jjang051.security.vote.controller;

import com.jjang051.security.vote.dao.VoteDao;
import com.jjang051.security.vote.dto.VoteDto;
import com.jjang051.security.vote.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vote")
@RequiredArgsConstructor
@Slf4j
public class VoteController {
    private final VoteService voteService;

    @GetMapping({"","/","/list"})
    public String list(Model model){
        List<VoteDto> voteDtoList = voteService.findAllVotes();
        model.addAttribute("voteDtoList",voteDtoList);
        return "vote/list";
    }
    @GetMapping("/{voteNo}")
    @ResponseBody
    public String detail(@PathVariable int voteNo, @RequestParam(name="voteNo") int voteNoParam, Model model){
        log.info("voteNo = {}", voteNo);
        log.info("voteNoParam = {}", voteNoParam);
        return "vote/detail";
    }

}
