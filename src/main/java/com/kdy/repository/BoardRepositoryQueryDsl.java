package com.kdy.repository;

import java.util.List;

import com.kdy.model.Board;
import com.kdy.model.Criteria;

public interface BoardRepositoryQueryDsl {
	List<Board> findAll10(Criteria cri);
}
