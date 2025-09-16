package com.example.chess.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	private Long pkUser;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private LocalDateTime createdAt;

}
