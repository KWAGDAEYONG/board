package com.kdy.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.kdy.model.Board;
import com.kdy.model.Criteria;
import com.kdy.model.QBoard;
import com.kdy.repository.BoardRepositoryQueryDsl;

public class BoardRepositoryImpl extends QueryDslRepositorySupport implements BoardRepositoryQueryDsl {
	public BoardRepositoryImpl(){
		super(Board.class);
	}
	

	
	@Override
	public List<Board> findAll10(Criteria cri){
	
		QBoard qboard = QBoard.board;
		return from(qboard)
				.where(qboard.deleted.eq(false))
				.where(qboard.bno.gt(0))
				.offset(cri.offset())
				.limit(cri.getPerPageNum())
				.orderBy(qboard.bno.desc())
				.fetch();
	}
}
