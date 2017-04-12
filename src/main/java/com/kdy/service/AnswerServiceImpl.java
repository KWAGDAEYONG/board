package com.kdy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.model.Answer;
import com.kdy.model.Board;
import com.kdy.repository.AnswerRepository;

public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	BoardService boardService;
	
	@Override
	public void regist(Answer answer) throws Exception{
		answerRepository.save(answer);
	}
	@Override
	public void remove(Long rno) throws Exception{
		Answer dbAnswer = answerRepository.findOne(rno);
		dbAnswer.deleted();
		answerRepository.save(dbAnswer);
	}
	@Override
    public void modify(Long rno, Answer answer) throws  Exception{
		Answer dbAnswer = answerRepository.findOne(rno);
		dbAnswer.update(answer);
		answerRepository.save(dbAnswer);
    }
	@Override
    public List<Answer> list()throws Exception{
		return answerRepository.findAll();
    }
}
