package com.compact.info.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//주석 수정입니다
	@GetMapping("main")
	public String main() {
		return "index";
	}
}
