package com.kdy.service;

import java.util.List;

import com.kdy.model.Answer;
import com.kdy.model.Board;



public interface AnswerService {
	public void regist(Answer answer) throws Exception;
	public void remove(Long rno) throws Exception;
    public void modify(Long rno,Answer answer) throws  Exception;
    public List<Answer> list()throws Exception;
}
