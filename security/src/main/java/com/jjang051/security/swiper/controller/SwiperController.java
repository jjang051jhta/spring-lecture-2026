package com.jjang051.security.swiper.controller;

import com.jjang051.security.swiper.dto.MainSlideDto;
import com.jjang051.security.swiper.service.MainSlideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/swiper")
@RequiredArgsConstructor
@Slf4j
public class SwiperController {

    private final MainSlideService mainSlideService;
    @GetMapping({"/","/main"})
    public String swiperMain(Model model){
        List<MainSlideDto> mainSlideDtoList = mainSlideService.findAllSlides();
        model.addAttribute("mainSlideDtoList", mainSlideDtoList);
        return "swiper/main";
    }
    @GetMapping("/admin/insert")
    public String swiperAdmin(){
        return "swiper/admin";
    }

    @GetMapping("/admin/list")
    public String swiperList(Model model){
        List<MainSlideDto> mainSlideDtoList = mainSlideService.findAllSlides();
        model.addAttribute("mainSlideDtoList", mainSlideDtoList);
        return "swiper/list";
    }



    @PostMapping("/admin/slides")
    public String insertSlide(@ModelAttribute MainSlideDto mainSlideDto) throws IOException {
        mainSlideService.insertSlide(mainSlideDto);
        return "redirect:/swiper/admin";
    }

    @PostMapping("/admin/sort")
    @ResponseBody
    public String sortSlide(@RequestBody List<Integer> slideNos)  {
        log.info(slideNos.toString());
        mainSlideService.updateSort(slideNos);
        return "ok";
    }
}
