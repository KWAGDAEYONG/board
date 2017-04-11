package com.kdy.repository.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Service;

import com.kdy.model.Board;
import com.kdy.model.QBoard;
import com.kdy.model.SearchCriteria;
import com.kdy.repository.BoardRepositoryQueryDsl;
import com.querydsl.core.BooleanBuilder;


@Service
public class BoardRepositoryImpl extends QueryDslRepositorySupport implements BoardRepositoryQueryDsl{

	private List<Board> temp = new ArrayList<Board>();
	public BoardRepositoryImpl() {
		super(Board.class);
	}

	@Override
	public List<Board> findAll10(SearchCriteria cri) {

		QBoard qboard = QBoard.board;
		BooleanBuilder br = new BooleanBuilder();
		switch (cri.getSearchType()) {
			case "t":
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(qboard.title.eq(cri.getKeyword()))
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
			case "c":
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(qboard.content.like(cri.getKeyword()))
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
				
			case "w":
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(qboard.writer.eq(cri.getKeyword()))
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
			case "n":
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
			case "tc":	
				br.or(qboard.title.eq(cri.getKeyword()));
				br.or(qboard.content.like(cri.getKeyword()));
				
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(br)
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
			case "cw":
				br.or(qboard.writer.eq(cri.getKeyword()));
				br.or(qboard.content.like(cri.getKeyword()));
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(br)
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch();
				break;
			case "tcw":
				br.or(qboard.title.eq(cri.getKeyword()));
				br.or(qboard.writer.eq(cri.getKeyword()));
				br.or(qboard.content.like(cri.getKeyword()));
				temp = from(qboard)
						.where(qboard.deleted.eq(false))
						.where(qboard.bno.gt(0))
						.where(br)
						.offset(cri.offset())
						.limit(cri.getPerPageNum())
						.orderBy(qboard.bno.desc()).fetch(); 
				break;
		}
		
		return temp;
	}

	@Override
	public Long countPaging() {
		QBoard qboard = QBoard.board;
		return from(qboard).where(qboard.deleted.eq(false)).where(qboard.bno.gt(0)).fetchCount();
	}

}
