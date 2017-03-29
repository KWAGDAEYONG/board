package com.kdy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kdy.model.Board;
import com.kdy.service.BoardService;

/**
 * Created by user on 2017-03-29.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @PostMapping("/register")
    public String register(Board board) throws Exception {
        log.debug(board.toString());
        boardService.regist(board);
        
        //return "/board/success";
        return "redirect:/board/listAll";
    }

    @GetMapping("/register")
    public String registerForm() throws Exception{
        return "/board/register";
    }
    
    @GetMapping("/listAll")
    public String listAll() throws Exception{
    
    	return "/board/listAll";
    }
    
}
