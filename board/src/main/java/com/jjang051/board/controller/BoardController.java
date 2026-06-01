package com.jjang051.board.controller;

import com.jjang051.board.dto.BoardDto;
import com.jjang051.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")

public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.findAll();
        model.addAttribute("boardList",boardList);
        return "list";
    }
    @GetMapping("/view")
    public String view(@RequestParam(name="no", required = true) int no, Model model) {
        //redis(memory에 저장) 캐쉬용 데이터에 많이 사용
        boardService.increaseHit(no);
        BoardDto boardDto = boardService.findByNo(no);

        model.addAttribute("boardDto", boardDto);
        return "view";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write")
    public String writeProcess(@ModelAttribute BoardDto boardDto) {
        boardService.write(boardDto);
        return "redirect:/";
    }
}
