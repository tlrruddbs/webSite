package org.hello.service;

import java.util.List;

import org.hello.controller.utils.Pagination;
import org.hello.vo.MemberVo;

public interface MemberService {
	
	public void insertMember(MemberVo memberVo) throws Exception;
	
	public int idChk(MemberVo memberVo) throws Exception;
	
	public List<MemberVo> memberList();
	
	public MemberVo getMember(String userId);
	
	public int saveMemberInfo(MemberVo memberVo);
	
	public List<MemberVo> getMemberList(Pagination pagination) throws Exception;
}
