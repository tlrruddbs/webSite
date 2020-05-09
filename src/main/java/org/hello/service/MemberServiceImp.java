package org.hello.service;

import java.util.List;

import javax.inject.Inject;
 
import org.hello.controller.utils.Pagination;
import org.hello.dao.MemberDAO;
import org.hello.vo.BoardVo;
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
 
	@Override
	public List<MemberVo> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVo getMember(String userId) {
		return dao.getMember(userId);
	}

	@Override
	public int saveMemberInfo(MemberVo memberVo) {
		return dao.saveMemberInfo(memberVo);
	}

	@Override
	public List<MemberVo> getMemberList(Pagination pagination) throws Exception {
		return dao.getMemberList(pagination);
	}
}
