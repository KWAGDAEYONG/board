package com.kdy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.model.Board;
import com.kdy.model.Criteria;
import com.kdy.model.SearchCriteria;
import com.kdy.repository.BoardRepository;

/**
 * Created by user on 2017-03-29.
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;
    
 
    
    @Override
    public void regist(Board board) throws Exception {
        boardRepository.save(board);
    }

    @Override
    public Board read(Long bno) throws Exception {
        return boardRepository.findOne(bno);
    }

    @Override
    public void modify(Long bno, Board board) throws Exception {
        Board dbBoard = boardRepository.findOne(bno);
        dbBoard.update(board);
        boardRepository.save(dbBoard);
    }

    @Override
    public void remove(Long bno) throws Exception{
        Board dbBoard = boardRepository.findOne(bno);
        dbBoard.delete();
        boardRepository.save(dbBoard);
    }

    @Override
    public List<Board> findAll(SearchCriteria cri){
    
        return boardRepository.findAll10(cri);
    }
    
    @Override
    public Long countPaging(){
    	return boardRepository.count();
    }
    
}
