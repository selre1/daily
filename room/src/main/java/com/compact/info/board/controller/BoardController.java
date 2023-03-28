package com.compact.info.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compact.info.board.domain.Board;
import com.compact.info.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
//	@GetMapping("/list")
//	public String save(Board board) {
//		return "board/board-view";
//	} 원본



	@GetMapping("/listPage")
	public String listPage(Model model ) {
		System.out.println(boardService.getBoardList());
		model.addAttribute("list", boardService.getBoardList());
		return "board/board-view";
	}
//	@GetMapping("/list")
//	public String save(Model model) {
//		System.out.println(boardService.getBoardList());
//		model.addAttribute("list", boardService.getBoardList());
//		return "board-view";
//	}


	@GetMapping("/insertPage")
	public String insertPage(){
		return "board/insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(Board board){
		boardService.insertBoard(board);
		return "board-view";
	}
}