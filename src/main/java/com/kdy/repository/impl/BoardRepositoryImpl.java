package com.kdy.repository.impl;

import java.util.List;

import com.kdy.model.QBoard;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.kdy.model.Board;
import com.kdy.repository.BoardRepositoryQueryDsl;

public class BoardRepositoryImpl extends QueryDslRepositorySupport implements BoardRepositoryQueryDsl {
	public BoardRepositoryImpl(){
		super(Board.class);
	}
	
	@Override
	public List<Board> findAll10(){
		QBoard qboard = QBoard.board;
		return from(qboard).where(qboard.deleted.eq(false)).limit(10).orderBy(qboard.bno.desc()).fetch();
		//return null;
	}
}
