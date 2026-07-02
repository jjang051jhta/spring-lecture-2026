package com.jjang051.security.vote.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public class VoteDto {
    private int voteNo;
    private String title;
    private LocalDateTime regDate;
    private String regDateFormatted;
    //방금 전,1시간전,어제,2026
    private List<VoteItemDto> items;
    public String getRegDateFormatted() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(regDate, now);
        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();
        if(seconds < 60) {
            return "방금 전";
        }
        if(minutes < 60) {
            return minutes+"분 전";
        }
        if(hours < 24) {
            return hours+"시간 전";
        }
        if(days < 7) {
            return days+"일 전";
        }
        return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
