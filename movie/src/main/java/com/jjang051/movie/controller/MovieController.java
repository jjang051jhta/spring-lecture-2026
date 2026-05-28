package com.jjang051.movie.controller;

import com.jjang051.movie.dto.MovieDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
//    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    public String test() {
//        return "list";
//    }
    // jdbc connection   -->  jdbcTemplate  -->  mybatis(sql을 분리 (xml)) -->
    // jpa(java method로 db 컨트롤)
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String username = "spring";
    private final String password = "1234";

    @GetMapping("/list")
    public String list(Model model) {
        //String sql = "SELECT no,title,reserve_yn as reserveYn FROM movie";
        String sql = "SELECT * FROM movie";
        List<MovieDto> movieList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int no = rs.getInt("no");
                String title = rs.getString("title");
                //int reserveYn = rs.getInt("reserveYn");
                String reserveYn = rs.getString("reserve_yn");
                MovieDto movieDto = MovieDto.builder()
                        .no(no)
                        .title(title)
                        .reserveYn(reserveYn)
                        .build();
                movieList.add(movieDto);
            }
            System.out.println(movieList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("movieList",movieList);
        return "list";
    }
    @PostMapping("/write")
    public String write() {
        return "redirect:/list";
    }
    @PostMapping("/reserve")
    public String reserve() {
        return "redirect:/list";
    }
}
