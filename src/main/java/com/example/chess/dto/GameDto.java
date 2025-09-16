package com.example.chess.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameDto {
	
	private Long pkGame;
    private String gameId;
    private Long whiteUser;
    private Long blackUser;
    private String result;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
