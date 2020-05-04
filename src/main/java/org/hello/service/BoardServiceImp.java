package org.hello.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hello.controller.utils.Pagination;
import org.hello.dao.BoardDAO;
import org.hello.vo.BoardVo;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImp implements BoardService{

	@Inject
    private BoardDAO dao;
    
    @Override
    public void create(BoardVo vo) throws Exception {
        dao.create(vo);
    }
 
    @Override
    public List<BoardVo> listAll() throws Exception {
        return dao.listAll();
    }
    
	@Override
	public List<BoardVo> getBoardList(Pagination pagination) throws Exception {
		return dao.getBoardList(pagination);
	}
	
	@Override
	public int getBoardListCnt(Map map) throws Exception {
		return dao.getBoardListCnt(map);
	}
	
    @Override
    public BoardVo read(int seq) throws Exception {
        return dao.read(seq);
    }
 
    @Override
    public void delete(Integer seq) throws Exception {
        dao.delete(seq);
    }
 
    @Override
    public int update(BoardVo boardVo) throws Exception {
        return dao.update(boardVo);
    }
 
	@Override
	public void plusCnt(int seq) {
		dao.plusCnt(seq);
	}

	@Override
	public List<BoardVo> myBoardList(String id) throws Exception {
		dao.myBoardList(id);
		return dao.myBoardList(id);
	}
	
	@Override
	public int myBoardCountList(String id) throws Exception {
		return dao.myBoardCountList(id);
	}	

	@Override
	public List<BoardVo> searchList(Map map) throws Exception {
		dao.searchList(map);
		return dao.searchList(map);
	}

	
}
