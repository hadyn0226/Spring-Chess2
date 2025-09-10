package com.example.chess.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chess.dto.MatchRequest;
import com.example.chess.dto.MatchResponse;
import com.example.chess.service.MatchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AsyncController {
	
	private final MatchService matchService;
	
	@PostMapping("/ajax/test")
	public Map<String, String> getData(@RequestBody MatchRequest request){
		System.out.println("Ajax test!");
		Map<String, String> map = new HashMap<>();
		map.put("msg", "Hello Ajax");
		return map;
	}
	
	@PostMapping("/ajax/match")
	public MatchResponse match(@RequestBody MatchRequest request) {
		System.out.println("MatchRequest = " + request);
	    return matchService.addToQueue(request.getUserId());
	}
	
	
}
