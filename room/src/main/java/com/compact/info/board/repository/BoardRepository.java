package com.compact.info.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compact.info.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

}