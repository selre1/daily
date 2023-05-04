package com.compact.info.board.dto;

import com.compact.info.board.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime updateedAt;



    public Board toEntity(){
        return Board.builder()
                .boardIdx(boardIdx)
                .title(title)
                .content(content)
                .hit(hit)
                .creatorId(creatorId)
                .updateedAt(updateedAt)
                .build();
    }

    @Builder
    public BoardDto(Long boardIdx, String title, String content, int hit, String creatorId, LocalDateTime updateedAt){
        this.boardIdx = boardIdx;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.creatorId = creatorId;
        this.updateedAt = updateedAt;
    }

    //조회수 증가
    public void increaseHits(){
        this.hit++;
    }
}
