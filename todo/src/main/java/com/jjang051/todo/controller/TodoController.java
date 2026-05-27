package com.jjang051.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TodoController {
    //1. 글자, 완료,

    private List<Map<String,Object>> todoList = new ArrayList<>();
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("todoList",todoList);
        return "list";
    }
    @PostMapping("/write")
    public String write(
            @RequestParam(name="todo", required = true) String todo
            ) {
        Map<String,Object> map = new HashMap<>();

        map.put("content",todo);
        map.put("complete",false);
        todoList.add(map); //산책,공부
        System.out.println(todoList.toString());
        return "redirect:/list";
    }
    @PostMapping("/complete")
    public String complete(@RequestParam(name="index",required = true) int index) {
        System.out.println(index);
        Map<String,Object> map = todoList.get(index); //2
        map.put("complete",true);
        return "redirect:/list";
    }
}
