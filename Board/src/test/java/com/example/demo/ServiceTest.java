package com.example.demo;

import java.sql.Time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.BoardDTO;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.service.BoardService;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired 
	private BoardMapper boardMapper;
	
	@Test
	void 가입테스트() throws Exception {
		BoardDTO params = new BoardDTO();
		params.setIdx(56L);
		params.setTitle("51번째 게시글 제목");
		params.setContent("51번째 게시글 내용");
		params.setWriter("51번째 게시글 작성자");
		params.setNoticeYn("Y");
		params.setSecretYn("Y");
		
		boardMapper.insertBoard(params);
		
		boolean result = boardService.registerBoard(params);
		Assertions.assertThat(result).isTrue();
		
	}

	
}
