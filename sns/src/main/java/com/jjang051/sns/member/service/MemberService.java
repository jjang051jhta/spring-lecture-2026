package com.jjang051.sns.member.service;

import com.jjang051.sns.global.utils.DateTimeRenameStrategy;
import com.jjang051.sns.global.utils.FileRenameStrategy;
import com.jjang051.sns.member.dto.MemberUpdateDto;
import com.jjang051.sns.member.dto.SignupDto;
import com.jjang051.sns.member.entity.Member;
import com.jjang051.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

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

        String encodedPassword = passwordEncoder.encode(signupDto.getUserPassword());
        Member member = signupDto.toEntity(imageUrl,encodedPassword);
        return memberRepository.save(member);
    }

    public Boolean existsUserId(String userId) {
        return memberRepository.existsByUserId(userId);
    }

    @Transactional
    public void updateMember(String userId, MemberUpdateDto memberUpdateDto) {
        log.info("uopdate member");
        Member findedMember = memberRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("회원이 존재하지 않습니다."));
        String profileUrl = null;
        MultipartFile profile = memberUpdateDto.getProfile();
        if(profile != null && !profile.isEmpty()) {
            try {
                Path uploadPath = Paths.get(uploadDir);
                Files.createDirectories(uploadPath);
                FileRenameStrategy fileRenameStrategy = new DateTimeRenameStrategy();
                String fileName = fileRenameStrategy.rename(profile.getOriginalFilename());
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(profile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                profileUrl = "/upload/" + fileName;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //findedMember.setUserName(memberUpdateDto.getUserName());
        //findedMember.setProfile(profileUrl);
        //memberRepository.save(findedMember);
        log.info("uopdate member 02");
        findedMember.updateProfile(memberUpdateDto.getUserName(), profileUrl);
        log.info("uopdate member 03");
    }
}
