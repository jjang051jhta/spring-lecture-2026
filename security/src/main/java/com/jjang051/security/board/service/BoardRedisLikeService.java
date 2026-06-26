package com.jjang051.security.board.service;

import com.jjang051.security.board.dto.LikeResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardRedisLikeService {
    private final StringRedisTemplate redisTemplate;
    private String getLikeKey(int boardNo) {
        return "board:like:" + boardNo;
    }
    public LikeResultDto toggleLike(int boardNo, String userId) {
        //board:like:8,
        String key = getLikeKey(boardNo);
        Boolean alreadyLiked = redisTemplate.opsForSet().isMember(key, userId);
        boolean liked;
        if(Boolean.TRUE.equals(alreadyLiked)) {
            redisTemplate.opsForSet().remove(key, userId);
            liked = false;
        } else {
            redisTemplate.opsForSet().add(key, userId);
            liked = true;
        }
        Long size =  redisTemplate.opsForSet().size(key);
        log.info("getLikeKey(boardNo) size {}", size);
        return new LikeResultDto(liked, size == null ? 0 : size);
    }
}
