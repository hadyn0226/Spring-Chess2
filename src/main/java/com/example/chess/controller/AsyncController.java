package com.example.chess.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
	
	@GetMapping("/ajax/test")
	public Map<String, String> getData(){
		System.out.println("Ajax test!");
		Map<String, String> map = new HashMap<>();
		map.put("msg", "Hello Ajax");
		return map;
	}
}
