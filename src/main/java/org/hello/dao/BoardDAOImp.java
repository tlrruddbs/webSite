package org.hello.dao;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.controller.utils.Pagination;
import org.hello.dao.BoardDAO;
import org.hello.vo.BoardVo;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO {
  @Inject
  private SqlSession sqlSession;
  
  private static String namespace = "org.hello.mapper.BoardMapper";
  
  public void create(BoardVo boardVo) throws Exception {
    this.sqlSession.insert(String.valueOf(namespace) + ".insertBoard", boardVo);
  }
  
  public List<BoardVo> listAll() throws Exception {
    this.sqlSession.selectList(String.valueOf(namespace) + ".listBoard");
    return this.sqlSession.selectList(String.valueOf(namespace) + ".listBoard");
  }
  
  public List<BoardVo> getBoardList(Pagination pagination) throws Exception {
    System.out.println("pagination option:" + pagination.getStartIndex() + ", " + pagination.getPageSize());
    this.sqlSession.selectList(String.valueOf(namespace) + ".getBoardList", pagination);
    return this.sqlSession.selectList(String.valueOf(namespace) + ".getBoardList", pagination);
  }
  
  public int getBoardListCnt(Map map) throws Exception {
    return ((Integer)this.sqlSession.selectOne(String.valueOf(namespace) + ".getBoardListCnt", map)).intValue();
  }
  
  public BoardVo read(int seq) throws Exception {
    return (BoardVo)this.sqlSession.selectOne(String.valueOf(namespace) + ".detailBoard", Integer.valueOf(seq));
  }
  
  public void delete(Integer seq) throws Exception {
    System.out.println("seq:" + seq);
    this.sqlSession.delete(String.valueOf(namespace) + ".deleteBoard", seq);
  }
  
  public int update(BoardVo boardVo) throws Exception {
    System.out.println("dao update:" + boardVo.toString());
    return this.sqlSession.update(String.valueOf(namespace) + ".updateBoard", boardVo);
  }
  
  public void plusCnt(int seq) {
    this.sqlSession.update(String.valueOf(namespace) + ".plusCnt", Integer.valueOf(seq));
  }
  
  public List<BoardVo> myBoardList(String id) throws Exception {
    this.sqlSession.selectList(String.valueOf(namespace) + ".myBoardList", id);
    return this.sqlSession.selectList(String.valueOf(namespace) + ".myBoardList", id);
  }
  
  public int myBoardCountList(String id) throws Exception {
    return ((Integer)this.sqlSession.selectOne(String.valueOf(namespace) + ".myBoardCountList", id)).intValue();
  }
  
  public List<BoardVo> searchList(Map map) throws Exception {
    this.sqlSession.selectList(String.valueOf(namespace) + ".searchList", map);
    return this.sqlSession.selectList(String.valueOf(namespace) + ".searchList", map);
  }
}
