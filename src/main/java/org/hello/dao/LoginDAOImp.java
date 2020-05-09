package org.hello.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImp implements LoginDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace = "org.hello.mapper.LoginMapper";

	@Override
	public MemberVo loginRequest(MemberVo memberVo)throws Exception{
		return sqlSession.selectOne(namespace+".loginRequest",memberVo);
		 
	}
} 
