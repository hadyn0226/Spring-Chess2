package com.example.chess.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

	private Long pkComment;
    private Long fkPost;
    private Long fkUser;
    private String content;
    private LocalDateTime createdAt;
}
