package com.jjang051.security.swiper.service;

import com.jjang051.security.swiper.dao.MainSlideDao;
import com.jjang051.security.swiper.dto.MainSlideDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MainSlideService {
    @Value("${file.upload}")
    private String uploadPath;

    private final MainSlideDao mainSlideDao;

    public void insertSlide(MainSlideDto mainSlideDto) throws IOException {
        MultipartFile bgImage = mainSlideDto.getBgImage();
        if(bgImage != null && !bgImage.isEmpty()){
            String originalFileName = bgImage.getOriginalFilename();
            String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
            log.info("savedFileName = {}", savedFileName);
            Path path = Paths.get(uploadPath);
            Files.createDirectories(path);
            Path savedPath = path.resolve(savedFileName);
            Files.copy(bgImage.getInputStream(), savedPath, StandardCopyOption.REPLACE_EXISTING);
            mainSlideDto.setImageUrl("/upload/" + savedFileName);
            mainSlideDao.insertSlide(mainSlideDto);
        }
        log.info("insertSlide");
    }
}
