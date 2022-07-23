package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.CommentDTO;
import com.example.demo.service.CommentService;

@SpringBootTest
public class CommentTests {

	@Autowired
	private CommentService commentService;
	
	private final Logger log = LoggerFactory.getLogger(CommentTests.class);
	
	@Test
	public void registerComments() {
		int number = 20;
		
		for (int i = 1; i<= number; i++) {
			CommentDTO params = new CommentDTO();
			params.setBoardIdx((long) 1134);	// 댓글을 추가할 게시글 번호
			params.setContent(i + "번 댓글을 추가합니다.");
			params.setWriter(i + "번 회원");
			commentService.registerComment(params);
		}
		
		log.info("댓글 " + number +"개가 등록되었습니다.");
	}
	
	@Test
	public void deleteComment() {
		commentService.deleteComment((long) 10);	// 삭제할 댓글 번호
		
		getCommentList();
	}
	
	@Test
	public void getCommentList() {
		CommentDTO params = new CommentDTO();
		params.setBoardIdx((long) 1134);
		
		commentService.getCommentList(params);
	}
	
}
