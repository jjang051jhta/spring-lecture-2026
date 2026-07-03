package com.jjang051.security.swiper.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainSlideDto {
    private int slideNo;
    private String mainText;
    private String subText;
    private MultipartFile bgImage;
    private String imageUrl;
    private String visibleYn;
    private int sortOrder;
    private LocalDateTime regDate;
}
