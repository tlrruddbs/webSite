package org.hello.service;

import java.util.List;
import java.util.Map;

import org.hello.controller.utils.Pagination;
import org.hello.vo.BoardVo;

public interface BoardService {
	
public void create(BoardVo boardVo) throws Exception;
	 
	public List<BoardVo> listAll() throws Exception;
	
	public List<BoardVo> getBoardList(Pagination pagination) throws Exception;
	
	public int getBoardListCnt(Map map) throws Exception;
	
	public BoardVo read(int seq) throws Exception;
	
	public void delete(Integer seq) throws Exception;
	
	public int update(BoardVo boardVo) throws Exception;
	
	public void plusCnt(int seq);
	
	public List<BoardVo> myBoardList(String id) throws Exception;
	
	public int myBoardCountList(String id) throws Exception;
	
	public List<BoardVo> searchList(Map map) throws Exception;
	
}
