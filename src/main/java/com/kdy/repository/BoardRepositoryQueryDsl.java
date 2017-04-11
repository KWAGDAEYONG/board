package com.kdy.repository;

import java.util.List;

import com.kdy.model.Board;
import com.kdy.model.Criteria;
import com.kdy.model.SearchCriteria;

public interface BoardRepositoryQueryDsl {
	List<Board> findAll10(SearchCriteria cri);
	Long countPaging();
}
