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
@Setter
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
	
	@OneToMany(mappedBy = "board")
	private List<BoardFile> boardFile = new ArrayList<>();


//	@Entity
//	@Table(name="BOARD")
//	@NoArgsConstructor
//	@Data
	public class board {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long BOARD_IDX;
		private int HIT;
		private String TITLE;
		private String CONTENT;
	}
}
