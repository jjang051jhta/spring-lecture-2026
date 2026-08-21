package com.jjang051.sns.story.service;

import com.jjang051.sns.global.utils.DateTimeRenameStrategy;
import com.jjang051.sns.global.utils.FileRenameStrategy;
import com.jjang051.sns.global.utils.UUIDRenameStrategy;
import com.jjang051.sns.story.dto.StoryResponseDto;
import com.jjang051.sns.story.dto.StoryWriteDto;
import com.jjang051.sns.story.entity.Story;
import com.jjang051.sns.story.repository.StoryRepsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoryService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final StoryRepsitory storyRepsitory;
    public StoryResponseDto saveStory(StoryWriteDto storyWriteDto) {
        log.info("uploadDir {}", uploadDir);
        String imageUrl = null;
        MultipartFile image = storyWriteDto.getImage();
        if(image != null && !image.isEmpty()) {

            try {
                Path uploadPath = Paths.get(uploadDir);
                Files.createDirectories(uploadPath); //io 는 보통 예외처리 해야 한다.
                FileRenameStrategy fileRenameStrategy = new UUIDRenameStrategy();
                //String fileName = UUID.randomUUID()+"_"+image.getOriginalFilename();
                String fileName = fileRenameStrategy.rename(image.getOriginalFilename());
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                imageUrl = "/upload/"+fileName;
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 실패");
            }
        }
        Story story = storyWriteDto.toEntity(imageUrl);
        //storyRepsitory.save(story)  save메서드는 entity를 리턴한다.  entity를 StroyResponseSto로 바꿔주는 게 필요한다.
        Story savedStory = storyRepsitory.save(story);
        return StoryResponseDto.from(savedStory);
        //dto를 받아서 entity로 만들어서 db에 저장
        //entity를 받아서 dto로 변환해서 api로 리턴
    }

    public List<StoryResponseDto> findAllStory() {
        //List<Stoty>
        return  storyRepsitory.findAllByOrderByIdDesc()
                              .stream()
                              .map(StoryResponseDto::from)
                              .toList();
    }
    public Page<StoryResponseDto> findAllStoryPage(int page, int size) {
        //List<Stoty>
        Pageable pageable = PageRequest.of(page, size);
        return  storyRepsitory.findAllByOrderByIdDesc(pageable)
                .map(StoryResponseDto::from);
    }
}
