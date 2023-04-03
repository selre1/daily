package com.compact.info.board.domain;

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

	@Builder
	public Board(Long boardIdx, String title, String content, int hit, String creatorId) {
		this.boardIdx = boardIdx;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.creatorId = creatorId;
	}

	@OneToMany(mappedBy = "board")
	private List<BoardFile> boardFile = new ArrayList<>();
}
