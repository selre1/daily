package com.compact.info.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//변경
	@GetMapping("main")
	public String main() {
		return "index";
	}
}
