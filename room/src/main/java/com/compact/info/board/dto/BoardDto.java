package com.compact.info.board.dto;

import com.compact.info.board.domain.Board;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardDto {
    private Long boardIdx;
    private String title;
    private String content;
    private  int hit;
    private String creatorId;

    public Board toEntity(){
        return Board.builder()
                .boardIdx(boardIdx)
                .title(title)
                .content(content)
                .hit(hit)
                .creatorId(creatorId)
                .build();
    }

    @Builder
    public BoardDto(Long boardIdx, String title, String content, int hit, String creatorId){
        this.boardIdx = boardIdx;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.creatorId = creatorId;
    }
}
