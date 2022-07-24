package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CommentDTO;
import com.example.demo.mapper.CommentMapper;

import groovy.util.logging.Slf4j;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	private static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

	@Override
	public boolean registerComment(CommentDTO params) {
		int queryResult = 0;
		
		if (params.getIdx() == null) {
			queryResult = commentMapper.insertComment(params);
			log.info("게시글 등록");
		} else {
			queryResult = commentMapper.updateComment(params);
			log.info("게시글 수정");
		}
		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteComment(Long idx) {
		int queryResult = 0;
		
		CommentDTO comment = commentMapper.selectCommentDetail(idx);
		
		if (comment != null && "N".equals(comment.getDeleteYn())) {
			queryResult = commentMapper.deleteComment(idx);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();
		
		int commentTotalCount = commentMapper.selectCommentTotalCount(params);
		
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}
		
		return commentList;
	}

}
