package org.hello.service;

import java.util.List;
import java.util.Map;

import org.hello.controller.utils.Pagination;
import org.hello.vo.AddVo;
import org.hello.vo.MemberVo;

public interface MemberService {
	
	public void insertMember(MemberVo memberVo) throws Exception;
	
	public int idChk(MemberVo memberVo) throws Exception;
	
	public List<MemberVo> memberList();
	
	public MemberVo getMember(String userId);
	
	public int saveMemberInfo(MemberVo memberVo);
	
	public List<Map> getMemberList(Pagination pagination) throws Exception;
	
	public List<Map> getMemberListAuthority() throws Exception;
	
	public void insertUserPower(Map map) throws Exception;
	
	public int upAuthority(String userId) throws Exception;
	
	public int authorityIdChk(String selectId) throws Exception;
	
	public int authorityDeleteChk(Map map) throws Exception;
	
	public int deleteAuthorityId(String selectId) throws Exception;
	
	public int updateUserPassWord(MemberVo memberVo) throws Exception;
	
	public MemberVo getUserInfo(String userId) throws Exception;
	
	public int memberModify(MemberVo memberVo)throws Exception;
}
 