package com.kdy.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.kdy.model.Board;

public interface BoardRepositoryQueryDsl {
	List<Board> findAll10();
}
