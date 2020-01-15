package org.hello.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hello.vo.BoardVo;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "org.hello.mapper.BoardMapper";
	
	@Override
	public void create(BoardVo boardVo) throws Exception {
		sqlSession.insert(namespace+".insertBoard", boardVo);
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		sqlSession.selectList(namespace+".listBoard");
		return sqlSession.selectList(namespace+".listBoard");
	}

	@Override
	public BoardVo read(int seq) throws Exception {
		return sqlSession.selectOne(namespace+".detailBoard", seq);
	}

	@Override
	public void delete(Integer seq) throws Exception {
		System.out.println("seq:"+seq);
		sqlSession.delete(namespace+".deleteBoard", seq);
	}

	@Override
	public int update(BoardVo boardVo) throws Exception {
		System.out.println("dao update:"+boardVo.toString());
		return sqlSession.update(namespace+".updateBoard", boardVo);
		
	}

	@Override
	public void plusCnt(int seq) {
		sqlSession.update(namespace+".plusCnt",seq);
		
	}

	@Override
	public List<BoardVo> myBoardList(String id) throws Exception {
		sqlSession.selectList(namespace+".myBoardList", id);
		return sqlSession.selectList(namespace+".myBoardList", id);
	}

	@Override
	public List<BoardVo> searchList(Map map) throws Exception {
		sqlSession.selectList(namespace+".searchList", map);
		return sqlSession.selectList(namespace+".searchList", map);
	}

}
