package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private BoardService boardService;

    @GetMapping("/board")
    public String listForm() {
        return "board/list";
    }

    @GetMapping("/board/write")
    public String writeForm() {
        return "board/write";
    }

    @PostMapping("/board/write")
    public String write(BoardDto boardDto) {
        boardService.saveArticle(boardDto);
        return "redirect:/";
    }

}
