package com.jjang051.security.board.controller;

import com.jjang051.security.board.dto.BoardDto;
import com.jjang051.security.board.service.BoardService;
import com.jjang051.security.member.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/write")
    public String write() {
        return "board/write";
    }
    @PostMapping("/write")
    public String writeProcess(@ModelAttribute BoardDto boardDto,
                               @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        boardDto.setAuthor(customUserDetails.getMemberDto().getUserName());
        boardService.write(boardDto);
        return "board/list";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
}
