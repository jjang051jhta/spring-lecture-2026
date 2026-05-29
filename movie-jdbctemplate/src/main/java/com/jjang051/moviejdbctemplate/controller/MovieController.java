package com.jjang051.moviejdbctemplate.controller;

import com.jjang051.moviejdbctemplate.dto.MovieDto;
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

    private final JdbcTemplate jdbcTemplate;
    //생성자의 매개변수로 처리  생성자 주입 방식



    @GetMapping("/list")
    public String list(Model model) {
        String sql =  "SELECT * FROM movie";
        //queryForObject
        List<MovieDto> movieList = jdbcTemplate.query(sql,(rs, rowNum) ->
                    MovieDto.builder()
                            .no(rs.getInt("no"))
                            .title(rs.getString("title"))
                            .reserveYn(rs.getString("reserve_yn"))
                            .build()
                );
        model.addAttribute("movieList",movieList);
        return "list";
    }
    @GetMapping("/list02")
    public String list02(Model model) {
        String sql =  "SELECT * FROM movie";
        List<MovieDto> movieList = jdbcTemplate.query(sql, new RowMapper<MovieDto>() {
                    @Override
                    public MovieDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return MovieDto.builder()
                                .no(rs.getInt("no"))
                                .title(rs.getString("title"))
                                .reserveYn(rs.getString("reserve_yn"))
                                .build();
                    }
                }
        );
        model.addAttribute("movieList",movieList);
        return "list";
    }
    @PostMapping("/write")
    public String write(@RequestParam(name="title", required = true) String title) {
        String sql = "INSERT INTO movie (no,title,reserve_yn) values (movie_seq.nextval,?,'N')";
        jdbcTemplate.update(sql,title);
        return "redirect:/movie/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(name="no", required = true) int no) {
        String sql = "DELETE FROM movie WHERE no = ?";
        jdbcTemplate.update(sql,no);
        return "redirect:/movie/list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(name="no", required = true) int no) {
        String sql = "UPDATE movie SET reserve_yn = 'Y' WHERE no = ?";
        jdbcTemplate.update(sql,no);
        return "redirect:/movie/list";
    }


}
