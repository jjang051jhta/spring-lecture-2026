package com.jjang051.moviejdbctemplate.controller;

import com.jjang051.moviejdbctemplate.dto.MovieDto;
import com.jjang051.moviejdbctemplate.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/movie")
public class MovieController {
    //의존성 주입 (DI)
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    //생성자의 매개변수로 처리  생성자 주입 방식

    private final MovieService movieService;


    @GetMapping("/list")
    public String list(Model model) {
        List<MovieDto> movieList = movieService.findAll();
        model.addAttribute("movieList",movieList);
        return "list";
    }
    @GetMapping("/list02")
    public String list02(Model model) {
        List<MovieDto> movieList = movieService.findAll02();
        model.addAttribute("movieList",movieList);
        return "list";
    }
    @PostMapping("/write")
    public String write(@RequestParam(name="title", required = true) String title) {

        return "redirect:/movie/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(name="no", required = true) int no) {
        movieService.delete(no);
        return "redirect:/movie/list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(name="no", required = true) int no) {
        movieService.update(no);
        return "redirect:/movie/list";
    }


}
