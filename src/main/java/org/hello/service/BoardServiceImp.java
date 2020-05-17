package org.hello.service;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.hello.controller.utils.Pagination;
import org.hello.dao.BoardDAO;
import org.hello.service.BoardService;
import org.hello.vo.BoardVo;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImp implements BoardService {
  @Inject
  private BoardDAO dao;
  
  public void create(BoardVo vo) throws Exception {
    this.dao.create(vo);
  }
  
  public List<BoardVo> listAll() throws Exception {
    return this.dao.listAll();
  }
  
  public List<BoardVo> getBoardList(Pagination pagination) throws Exception {
    return this.dao.getBoardList(pagination);
  } 
  
  public int getBoardListCnt(Map map) throws Exception {
    return this.dao.getBoardListCnt(map);
  }
  
  public BoardVo read(int seq) throws Exception {
    return this.dao.read(seq);
  }
  
  public void delete(Integer seq) throws Exception {
    this.dao.delete(seq);
  }
  
  public int update(BoardVo boardVo) throws Exception {
    return this.dao.update(boardVo);
  }
  
  public void plusCnt(int seq) {
    this.dao.plusCnt(seq);
  }
  
  public List<BoardVo> myBoardList(String id) throws Exception {
    this.dao.myBoardList(id);
    return this.dao.myBoardList(id);
  }
  
  public int myBoardCountList(String id) throws Exception {
    return this.dao.myBoardCountList(id);
  }
  
  public List<BoardVo> searchList(Map map) throws Exception {
    this.dao.searchList(map);
    return this.dao.searchList(map);
  }

@Override
public List<BoardVo> getMyBoardList(Map map) throws Exception {
	return dao.getMyBoardList(map);
}
}
