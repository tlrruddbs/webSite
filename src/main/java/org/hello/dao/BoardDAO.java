package org.hello.dao;

import java.util.List;
import java.util.Map;

import org.hello.vo.BoardVo;

public interface BoardDAO {
	
	public void create(BoardVo boardVo) throws Exception;
	
	public List<BoardVo> listAll() throws Exception;
	
	public BoardVo read(int seq) throws Exception;
	
	public void delete(Integer seq) throws Exception;
	
	public int update(BoardVo boardVo) throws Exception;
	
	public List<BoardVo> myBoardList(String id) throws Exception;
	
	public void plusCnt(int seq);
	
	public List<BoardVo> searchList(Map map) throws Exception;
}