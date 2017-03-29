package com.kdy.service;

import com.kdy.model.Board;

import java.util.List;

/**
 * Created by user on 2017-03-29.
 */
public interface BoardService {
    public void regist(Board board) throws Exception;
    public Board read(Long bno) throws Exception;
    public void modify(Long bno,Board board) throws  Exception;
    public void remove(Long bno) throws Exception;
    public List<Board> findAll() throws Exception;
}
