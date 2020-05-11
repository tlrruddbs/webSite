package org.hello.service;

import org.hello.dao.LoginDAO;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService{
	@Autowired
    private LoginDAO dao;
	
	@Override
	public MemberVo loginRequest(MemberVo memberVo)throws Exception{
		return dao.loginRequest(memberVo);
	} 
}
