package com.kdy.service;

import com.kdy.model.Board;
import com.kdy.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Board> findAll(){
      
        return boardRepository.findAll10();
    }
}
