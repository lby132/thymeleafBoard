package com.example.demo.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.BoardDTO;
import com.example.demo.paging.Criteria;

@Mapper
public interface BoardMapper {
	
	public int insertBoard(BoardDTO params);
	
	public BoardDTO selectBoardDetail(Long idx);
	
	public int updateBoard(BoardDTO params);
	
	public int deleteBoard(Long idx);
	
	public List<BoardDTO> selectBoardList(Criteria criteria);
	
	public int selectBoardTotalCount(Criteria criteria);
}
