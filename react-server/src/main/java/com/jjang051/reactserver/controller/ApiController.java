package com.jjang051.reactserver.controller;

import com.jjang051.reactserver.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ApiController {
    @GetMapping("/hello")
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","jang sung ho");
        map.put("age",20);
        map.put("major","컴공");
        return map;
    }
    @GetMapping("/user")
    public User user(){
        User user = User.builder()
                .name("jang sung ho")
                .age(20)
                .major("법학")
                .build();
        return user;
    }
    @PostMapping("/user")
    public User user02(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getMajor());
        return user;
    }
}
