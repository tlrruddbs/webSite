package org.hello.dao;

import org.hello.vo.MemberVo;

public interface MemberDAO {
   
    public void insertMember(MemberVo vo);
   
    public int idChk(MemberVo vo);
}