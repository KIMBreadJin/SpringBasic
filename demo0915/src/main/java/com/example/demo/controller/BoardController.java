package com.example.demo.controller;


import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.BoardDto;
import com.example.demo.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;
    public BoardController (BoardService boardService){
        this.boardService=boardService;
    }
    @GetMapping("/")
    public String list(Model model){
        System.out.println("this is list controller ");
        List<BoardDto> boardDtoList = boardService.getBoardList();
        boardDtoList.forEach(i -> System.out.println(i));
        model.addAttribute( "postList", boardDtoList);
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
    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post",boardDto);
        return "board/detail.html";
    }
    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post",boardDto);
        return "board/edit.html";
    }
    @PutMapping("/post/edit/{id}")
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") long id) {
        boardService.deletePost(id);
        return "redirect:/";
    }
}
