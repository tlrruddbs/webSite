package org.hello.dao;

import java.util.List;
import java.util.Map;

import org.hello.vo.MemberVo;

public interface MemberDAO {
   
    public void insertMember(MemberVo vo);
   
    public int idChk(MemberVo vo);
    
    public List<MemberVo> memberList();
}