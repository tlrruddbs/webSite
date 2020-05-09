package org.hello.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.controller.utils.Pagination;
import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository 
public class MemberDAOImp implements MemberDAO {

	@Autowired
    private SqlSession sqlSession;
	
    private static String namespace = "org.hello.mapper.MemberMapper";
   
    @Override
    public void insertMember(MemberVo memberVo) {
    	System.out.println("dao:"+memberVo.toString());
        sqlSession.insert(namespace+".insertMember", memberVo);
    }

	@Override
	public int idChk(MemberVo memberVo) {
		int result;
		result = sqlSession.selectOne(namespace+".idChk", memberVo.getUserId());
		memberVo.setIdChk(result);
		return result;
	}

	@Override
	public List<MemberVo> memberList() {
		sqlSession.selectList(namespace+".memberList");
		return sqlSession.selectList(namespace+".memberList");
		
	}

	@Override
	public MemberVo getMember(String userId) {
		sqlSession.selectOne(namespace+".getMember", userId);
		return sqlSession.selectOne(namespace+".getMember", userId);
	}

	@Override
	public int saveMemberInfo(MemberVo memberVo) {
		sqlSession.update(namespace+".saveMemberInfo", memberVo);
		return sqlSession.update(namespace+".saveMemberInfo", memberVo);
	}

	@Override
	public List<MemberVo> getMemberList(Pagination pagination) throws Exception {
		System.out.println("pagination option:"+pagination.getStartIndex()+", "+pagination.getPageSize());
		sqlSession.selectList(namespace+".getMemberList", pagination);
		return sqlSession.selectList(namespace+".getMemberList",pagination);
	}
	 
}