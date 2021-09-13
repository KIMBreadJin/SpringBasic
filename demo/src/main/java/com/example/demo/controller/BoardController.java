package com.example.demo.controller;


import com.example.demo.domain.entity.BoardDto;
import com.example.demo.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private BoardService boardService;
    public BoardController (BoardService boardService){
        this.boardService=boardService;
    }
    @GetMapping("/")
    public String list(){
        System.out.println("this is list controller ");
        return "board/list.html";
    }
    @GetMapping("post")
    public String post(){
        return  "board/post.html";
    }
    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
