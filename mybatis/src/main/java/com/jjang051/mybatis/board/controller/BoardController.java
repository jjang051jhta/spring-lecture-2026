package com.jjang051.mybatis.board.controller;

import com.jjang051.mybatis.board.dao.BoardDao;
import com.jjang051.mybatis.board.dto.BoardDto;
import com.jjang051.mybatis.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    //@ResponseBody
    public String write(@ModelAttribute BoardDto boardDto) {
        boardService.writeBoard(boardDto);
        System.out.println(boardDto.getContent());
        return "redirect:/";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("upload") MultipartFile upload) {
        String fileName = UUID.randomUUID() + "_" + upload.getOriginalFilename();
        Path uploadPath = Paths.get("C:/upload/");
        try {
            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path saveFile =  uploadPath.resolve(fileName);
            Files.copy(upload.getInputStream(), saveFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/upload/"+fileName;
    }
}
