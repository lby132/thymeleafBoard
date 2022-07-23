package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.CommentDTO;
import com.example.demo.domain.CommonDTO;

@Mapper
public interface CommentMapper {

	public int insertComment(CommentDTO params);

	public CommentDTO selectCommentDetail(Long idx);

	public int updateComment(CommentDTO params);

	public int deleteComment(Long idx);

	public List<CommentDTO> selectCommentList(CommentDTO params);

	public int selectCommentTotalCount(CommentDTO params);

}