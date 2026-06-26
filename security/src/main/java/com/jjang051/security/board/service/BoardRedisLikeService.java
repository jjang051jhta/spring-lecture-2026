package com.jjang051.security.board.service;

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
    public void toggleLike(int boardNo, String userId) {
        //board:like:8,
        String key = getLikeKey(boardNo);
        redisTemplate.opsForSet().add(key, userId);
        Long size =  redisTemplate.opsForList().size(key);
        log.info("getLikeKey(boardNo) size {}", size);
    }
}
