package com.compact.info.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//헷갈리네
	@GetMapping("main")
	public String main() {
		return "index";
	}
}
