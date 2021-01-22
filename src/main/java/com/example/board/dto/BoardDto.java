package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .writerId(writerId)
                .title(title)
                .content(content)
                .build();

        return build;
    }

    @Builder
    public BoardDto(Long id, Long writerId, String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

}
