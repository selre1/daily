package com.compact.info.board.controller;

import com.compact.info.board.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.compact.info.board.service.BoardService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/list")
	public String listPage(Model model) {
		List<BoardDto> boardDtoList = boardService.getBoardList();
		model.addAttribute("boardList", boardDtoList);
		return "board/board-view";
	}

	@GetMapping("/write")
	public String write(){
		return "board/board-write";
	}

	@PostMapping("/writeBoard")
	public String write(BoardDto boardDto){
		boardService.write(boardDto);
		return "redirect:/";
	}
}