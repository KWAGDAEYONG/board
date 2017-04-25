package com.kdy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kdy.model.Answer;
import com.kdy.service.AnswerService;
import com.kdy.service.BoardService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/register")
	public Answer registerAnswer(@RequestParam("bno") Long bno, Answer answer) throws Exception{
		answer.setBoard(boardService.read(bno));
		return answerService.regist(answer);
	}
}
