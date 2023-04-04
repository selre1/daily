package com.compact.info.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.compact.info.board.dto.BoardDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compact.info.board.domain.Board;
import com.compact.info.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = boards.stream()
                .map(data -> modelMapper.map(data, BoardDto.class))
                .collect(Collectors.toList());
        return boardDtoList;
    }

    @Transactional
    public Long write(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getBoardIdx();
    }
}
