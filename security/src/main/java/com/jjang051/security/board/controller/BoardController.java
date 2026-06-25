package com.jjang051.security.board.controller;

import com.jjang051.security.board.dto.BoardDto;
import com.jjang051.security.member.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @GetMapping("/write")
    public String write() {
        return "board/write";
    }
    @PostMapping("/write")
    @ResponseBody
    public String writeProcess(@ModelAttribute BoardDto boardDto,
                               @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        boardDto.setAuthor(customUserDetails.getMemberDto().getUserName());
        return "board/list";
    }
}
