package org.hello.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hello.controller.utils.Pagination;
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
	public List<Map> getMemberList(Pagination pagination) throws Exception {
		return dao.getMemberList(pagination);
	}

	@Override
	public List<Map> getMemberListAuthority() throws Exception {
		return dao.getMemberListAuthority();
	}

	@Override
	public void insertUserPower(Map map) throws Exception {
		dao.insertUserPower(map);
		
	}

	@Override
	public int upAuthority(String userId) throws Exception {
		return dao.upAuthority(userId);
	}

	@Override
	public int authorityIdChk(String userId) throws Exception {
		return dao.authorityIdChk(userId);
	}

	@Override
	public int authorityDeleteChk(Map map) throws Exception {
		return dao.authorityDeleteChk(map);
	}

	@Override
	public int deleteAuthorityId(String selectId) throws Exception {
		return dao.deleteAuthorityId(selectId);
	}

	@Override
	public int updateUserPassWord(Map map) throws Exception {
		return dao.updateUserPassWord(map);
	}

	@Override
	public MemberVo getUserInfo(String userId) throws Exception {
		return dao.getUserInfo(userId);
	}

	@Override
	public int memberModify(Map map) throws Exception {
		return dao.memberModify(map);
	}
}
