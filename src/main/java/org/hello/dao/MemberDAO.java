package org.hello.dao;

import java.util.List;
import java.util.Map;

import org.hello.controller.utils.Pagination;
import org.hello.vo.MemberVo;

public interface MemberDAO {
   
    public void insertMember(MemberVo vo);
   
    public int idChk(MemberVo vo);
    
    public List<MemberVo> memberList();
    
    public MemberVo getMember(String userId);
    
    public int saveMemberInfo(MemberVo vo);
    
    public List<Map> getMemberList(Pagination pagination) throws Exception;
    
    public List<Map> getMemberListAuthority() throws Exception;
    
    public void insertUserPower(Map map) throws Exception;
    
    public int upAuthority(String userId) throws Exception;
    
    public int authorityIdChk(String selectId);
    
    public int authorityDeleteChk(Map map);
    
    public int deleteAuthorityId(String selectId);
    
    public int updateUserPassWord(Map map);
    
    public MemberVo getUserInfo(String userId);
    
    public int memberModify(Map map);
} 