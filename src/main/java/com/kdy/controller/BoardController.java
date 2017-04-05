package com.kdy.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdy.model.Board;
import com.kdy.model.Criteria;
import com.kdy.model.Paging;
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
        Date date = new Date();
      
      
        board.setRegdate(date);
        boardService.regist(board);
        
        //return "/board/success";
        return "redirect:/board/listAll";
    }

    @GetMapping("/register")
    public String registerForm() throws Exception{
        return "/board/register";
    }
    
    @GetMapping("/listAll")
    public String listAll(Model model, Criteria cri) throws Exception{
    	model.addAttribute("list", boardService.findAll(cri));
    	Paging page = new Paging();
    	page.setCri(cri);
    	page.setTotalCount(32);
    	System.out.println(page.toString());
    	model.addAttribute("page",page);
    	return "/board/listAll";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("bno") Long bno, Model model)throws Exception{
    	model.addAttribute("read",boardService.read(bno));
    	return "/board/read";
    }
   
    @GetMapping("/modify")
    public String modifyFrom(@RequestParam("bno") Long bno, Model model) throws Exception{
    	model.addAttribute("modify",boardService.read(bno));
    	
    	return "/board/modify";
    }
    
    @PostMapping("/modify")
    public String modify(@RequestParam("bno") Long bno, Board board) throws Exception{
    	Date date = new Date();
    	board.setRegdate(date);
    	boardService.modify(bno, board);
    
    	return "redirect:/board/listAll";
    }
    
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno)throws Exception{
    	boardService.remove(bno);
    	return "redirect:/board/listAll";
    }
    
}
