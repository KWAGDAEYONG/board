package com.kdy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.model.Answer;
import com.kdy.repository.AnswerRepository;



@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	public Answer regist(Answer answer){
		return answerRepository.save(answer);
	}
    public void modify(Long ano,Answer answer){
    	Answer dbAnswer = answerRepository.findOne(ano);
    	dbAnswer.update(answer);
    	answerRepository.save(dbAnswer);
    }
    public void remove(Long ano){
    	
    }
}
