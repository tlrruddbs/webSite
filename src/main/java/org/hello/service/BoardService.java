package org.hello.service;

import java.util.List;
import java.util.Map;
import org.hello.controller.utils.Pagination;
import org.hello.vo.BoardVo;

public interface BoardService {
  void create(BoardVo paramBoardVo) throws Exception;
  
  List<BoardVo> listAll() throws Exception;
  
  List<BoardVo> getBoardList(Pagination paramPagination) throws Exception;
  
  List<BoardVo> getMyBoardList(Map map)throws Exception;
  
  int getBoardListCnt(Map paramMap) throws Exception;
  
  BoardVo read(int paramInt) throws Exception;
  
  void delete(Integer paramInteger) throws Exception;
   
  int update(BoardVo paramBoardVo) throws Exception;
  
  void plusCnt(int paramInt);
  
  List<BoardVo> myBoardList(String paramString) throws Exception;
  
  int myBoardCountList(String paramString) throws Exception;
  
  List<BoardVo> searchList(Map paramMap) throws Exception;
  
  
}
