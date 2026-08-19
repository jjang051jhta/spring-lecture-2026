package com.jjang051.sns.member.service;

import com.jjang051.sns.global.utils.DateTimeRenameStrategy;
import com.jjang051.sns.global.utils.FileRenameStrategy;
import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final MemberRepository memberRepository;

    public Member signUp(SignupDto signupDto) {
        String imageUrl =  null;
        MultipartFile profile = signupDto.getProfile();
        if(profile != null && !profile.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                Files.createDirectories(uploadPath);
                FileRenameStrategy fileRenameStrategy = new DateTimeRenameStrategy();
                String fileName = fileRenameStrategy.rename(profile.getOriginalFilename());
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(profile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                imageUrl = "/upload/" + fileName;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Member member = signupDto.toEntity(imageUrl);
        return memberRepository.save(member);
    }

    public Boolean existsUserId(String userId) {
        return memberRepository.existsByUserId(userId);
    }
}
