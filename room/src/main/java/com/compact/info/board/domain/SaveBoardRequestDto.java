package com.compact.info.board.domain;

import lombok.Builder;

public class SaveBoardRequestDto {
    private Long boardIdx;
    private String title;
    private String content;
    private  int hit;
    private String creatorId;

    @Builder
    public SaveBoardRequestDto(Long boardIdx, String title, String content, int hit, String creatorId){
        this.boardIdx = boardIdx;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.creatorId = creatorId;
    }

    //dto -> entry
    public Board toEntry(){
        return Board.builder()
                .boardIdx(boardIdx)
                .title(title)
                .content(content)
                .hit(hit)
                .creatorId(creatorId)
                .build();
    }

}
