package com.board.dto;

import com.board.entity.BoardEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String username;

    public BoardEntity toEntity() {
        return new BoardEntity(id, title, content, username);
    }
}
