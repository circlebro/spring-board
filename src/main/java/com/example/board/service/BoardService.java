package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long saveArticle(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
