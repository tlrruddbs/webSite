package org.hello.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImp implements LoginDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "org.hello.mapper.LoginMapper";

	@Override
	public MemberVo loginRequest(MemberVo memberVo)throws Exception{
		return sqlSession.selectOne(namespace+".loginRequest",memberVo);
		
	}
}
