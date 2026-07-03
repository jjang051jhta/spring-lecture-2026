package com.jjang051.security.swiper.controller;

import com.jjang051.security.swiper.dto.MainSlideDto;
import com.jjang051.security.swiper.service.MainSlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/swiper")
@RequiredArgsConstructor
public class SwiperController {

    private final MainSlideService mainSlideService;
    @GetMapping({"/","/main"})
    public String swiperMain(Model model){
        List<MainSlideDto> mainSlideDtoList = mainSlideService.findAllSlides();
        model.addAttribute("mainSlideDtoList", mainSlideDtoList);
        return "swiper/main";
    }
    @GetMapping("/admin")
    public String swiperAdmin(){
        return "swiper/admin";
    }


    @PostMapping("/admin/slides")
    public String insertSlide(@ModelAttribute MainSlideDto mainSlideDto) throws IOException {
        mainSlideService.insertSlide(mainSlideDto);
        return "redirect:/swiper/admin";
    }
}
