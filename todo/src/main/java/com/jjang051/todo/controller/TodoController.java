package com.jjang051.todo.controller;

import com.jjang051.todo.dto.TodoDto;
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
    //dto data trasnfer object

    private List<TodoDto> todoList = new ArrayList<>();
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("todoList",todoList);
        return "list";
    }
    @PostMapping("/write")
    public String write(
            @RequestParam(name="todo", required = true) String todo
            ) {
//        Map<String,Object> map = new HashMap<>();
//
//        map.put("content",todo);
//        map.put("complete",false);
//        TodoDto todoDto = new TodoDto();
//        todoDto.setContent(todo);
//        todoDto.setComplete(false);
        TodoDto todoDto = TodoDto.builder()
                .content(todo)
                .complete(false)
                .build();
        todoList.add(todoDto); //산책,공부
        System.out.println(todoList.toString());
        return "redirect:/list";
    }
    @PostMapping("/complete")
    public String complete(@RequestParam(name="index",required = true) int index) {
        System.out.println(index);
        TodoDto todoDto = todoList.get(index); //2
        todoDto.setComplete(true);
        return "redirect:/list";
    }
}
