package com.example.chess.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoveDto {

	private Long pkMove;
	private Long fkGame;
	private Integer moveNumber;
	private String fromPos;
	private String toPos;
	private String piece;
	private String fen;
	private LocalDateTime createdAt;
}
