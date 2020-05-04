package org.hello.dao;

import java.util.List;
import java.util.Map;

import org.hello.controller.utils.Pagination;
import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;

public interface MemberDAO {
   
    public void insertMember(MemberVo vo);
   
    public int idChk(MemberVo vo);
    
    public List<MemberVo> memberList();
    
    public MemberVo getMember(String userId);
    
    public int saveMemberInfo(MemberVo vo);
    
    public List<MemberVo> getMemberList(Pagination pagination) throws Exception;
} 