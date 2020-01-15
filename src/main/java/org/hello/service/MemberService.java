package org.hello.service;

import org.hello.vo.MemberVo;

public interface MemberService {
	
	public void insertMember(MemberVo memberVo) throws Exception;
	
	public int idChk(MemberVo memberVo) throws Exception;
}
