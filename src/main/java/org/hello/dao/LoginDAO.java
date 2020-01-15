package org.hello.dao;

import org.hello.vo.MemberVo;

public interface LoginDAO {
	
	public MemberVo loginRequest(MemberVo memberVo) throws Exception;
}
