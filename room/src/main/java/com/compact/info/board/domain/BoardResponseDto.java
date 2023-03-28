package com.compact.info.board.domain;

public class BoardResponseDto {
    private Long boardIdx;
    private String title;
    private String content;
    private  int hit;
    private String creatorId;

    //entry -> dto
    public BoardResponseDto(Board entry){
        this.boardIdx = entry.getBoardIdx();
        this.title = entry.getTitle();
        this.content = entry.getContent();
        this.hit = entry.getHit();
        this.creatorId = entry.getCreatorId();
    }



}
