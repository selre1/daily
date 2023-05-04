package com.compact.info.board.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.compact.info.boardfile.domain.BoardFile;
import com.compact.info.common.CommonDate;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends CommonDate{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardIdx;
	
	@Column(nullable = false)
	private String title;
	
	private String content;
	
	private int hit;
	
	private String creatorId;
	private LocalDateTime updateedAt;

	@Builder
	public Board(Long boardIdx, String title, String content, int hit, String creatorId, LocalDateTime updateedAt) {
		this.boardIdx = boardIdx;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.creatorId = creatorId;
		this.updateedAt = updateedAt;

	}

	@OneToMany(mappedBy = "board")
	private List<BoardFile> boardFile = new ArrayList<>();
}
