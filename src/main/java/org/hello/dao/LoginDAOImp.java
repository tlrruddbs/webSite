package org.hello.dao;

import java.util.HashMap;
import java.util.Map;

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
		Map<String,Object>map = new HashMap<>();
		map = sqlSession.selectOne(namespace+".loginRequest",memberVo);
		if(map==null) {
			return memberVo;
		}
		memberVo.setUserId((String)map.get("USERID"));
		memberVo.setUserPhoneNum((String)map.get("TEL"));
		memberVo.setUserPw((String)map.get("PASSWD"));
		memberVo.setUserEmail((String)map.get("EMAIL"));
		memberVo.setPower((int)map.get("POWER"));
		memberVo.setUserName((String)map.get("USERNM"));
		
		return memberVo;
		
	}
} 
