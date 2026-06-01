package com.jjang051.moviejdbctemplate.service;

import com.jjang051.moviejdbctemplate.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final JdbcTemplate jdbcTemplate;
    String sql =  "SELECT * FROM movie";
    public List<MovieDto> findAll() {
        List<MovieDto> movieList = jdbcTemplate.query(sql, (rs, rowNum) ->
                MovieDto.builder()
                        .no(rs.getInt("no"))
                        .title(rs.getString("title"))
                        .reserveYn(rs.getString("reserve_yn"))
                        .build()
        );
        return movieList;
    }
    public List<MovieDto> findAll02() {
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
        return movieList;
    }
    public void write(String title) {
        String sql = "INSERT INTO movie (no,title,reserve_yn) values (movie_seq.nextval,?,'N')";
        jdbcTemplate.update(sql,title);
    }
    public void delete(int no) {
        String sql = "DELETE FROM movie WHERE no = ?";
        jdbcTemplate.update(sql,no);
    }
    public void update(int no) {
        String sql = "UPDATE movie SET reserve_yn = 'Y' WHERE no = ?";
        jdbcTemplate.update(sql,no);
    }
}
