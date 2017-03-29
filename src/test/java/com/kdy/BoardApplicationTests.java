package com.kdy;

import com.kdy.model.Board;
import com.kdy.repository.BoardRepository;
import com.kdy.service.BoardService;
import com.kdy.service.BoardServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {

	@Autowired
	BoardService boardService;

	@Test
	public void insert() throws Exception {
		Board board = new Board();
		board.setTitle("새로운글");
		board.setContent("새로운글콘텐츠");
		board.setWriter("tester");

		boardService.regist(board);
	}

	@Test
	public void update() throws Exception{
		Board board = new Board();
		board.setBno(1L);
		board.setTitle("제목수정");
		board.setContent("수정콘텐츠");

		boardService.regist(board);
	}

	@Test
	public void findAll() throws Exception{
		boardService.findAll();
	}

}
