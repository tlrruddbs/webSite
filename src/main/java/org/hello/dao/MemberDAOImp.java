package org.hello.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Repository;

@Repository 
public class MemberDAOImp implements MemberDAO {

	@Inject
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
   
}