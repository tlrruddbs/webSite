package org.hello.service;

import javax.inject.Inject;

import org.hello.dao.MemberDAO;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService{

	@Inject
    private MemberDAO dao;
	
	@Override
	public void insertMember(MemberVo memberVo) throws Exception {
		dao.insertMember(memberVo);
	}

	@Override
	public int idChk(MemberVo memberVo) throws Exception {
		int result;
		result = dao.idChk(memberVo);
		
		return result;
	}
	

}
