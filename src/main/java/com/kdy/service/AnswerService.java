package com.kdy.service;

import com.kdy.model.Answer;

public interface AnswerService {
	public Answer regist(Answer answer) throws Exception;
    public void modify(Long bno,Answer answer) throws  Exception;
    public void remove(Long bno) throws Exception;
}
