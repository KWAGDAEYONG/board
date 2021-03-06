package com.kdy.service;

import java.util.List;

import com.kdy.model.Board;
import com.kdy.model.Criteria;
import com.kdy.model.SearchCriteria;

/**
 * Created by user on 2017-03-29.
 */
public interface BoardService {
    public void regist(Board board) throws Exception;
    public Board read(Long bno) throws Exception;
    public void modify(Long bno,Board board) throws  Exception;
    public void remove(Long bno) throws Exception;
    public List<Board> findAll(SearchCriteria cri) throws Exception;
    public Long countPaging(SearchCriteria cri) throws Exception;
}
