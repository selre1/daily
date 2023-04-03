package com.compact.info.board.service;

import java.util.ArrayList;
import java.util.List;

import com.compact.info.board.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compact.info.board.domain.Board;
import com.compact.info.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .boardIdx(board.getBoardIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .hit(board.getHit())
                    .creatorId(board.getCreatorId())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public Long write(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getBoardIdx();
    }
}
