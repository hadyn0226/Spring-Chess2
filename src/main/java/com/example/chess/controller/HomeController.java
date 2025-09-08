package com.example.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/websocket")
	public String webSocket() {
		return "websocket";
	}
	
	@GetMapping("/ajaxtest")
	public String ajaxtest(){
		return "ajaxtest";
	}
	
}
