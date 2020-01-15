package org.hello.service;

import javax.inject.Inject;

import org.hello.dao.LoginDAO;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService{
	@Inject
    private LoginDAO dao;
	
	@Override
	public MemberVo loginRequest(MemberVo memberVo)throws Exception{
		return dao.loginRequest(memberVo);
	}

}
