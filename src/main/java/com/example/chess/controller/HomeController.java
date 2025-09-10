package com.example.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String ajaxtest() {
		return "ajaxtest";
	}

	@GetMapping("/lobby")
	public String lobby() {
		return "lobby";
	}

	@GetMapping("/game/{gameId}")
	public String chessGame(@PathVariable("gameId") String gameId, Model model) {

		String playerColor = "white";

		model.addAttribute("gameId", gameId);
		model.addAttribute("playerColor", playerColor);

		return "game";
	}

}
