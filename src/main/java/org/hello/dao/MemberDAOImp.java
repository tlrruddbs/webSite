package org.hello.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.controller.utils.Pagination;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Repository;

@Repository 
public class MemberDAOImp implements MemberDAO {

	@Inject
    private SqlSession sqlSession;
	
    private static String namespace = "org.hello.mapper.MemberMapper";
   
    @Override
    public void insertMember(MemberVo memberVo) {
    	System.out.println("dao:"+memberVo.toString());
        sqlSession.insert(namespace+".insertMember", memberVo);
    }

	@Override
	public int idChk(MemberVo memberVo) {
		int result;
		result = sqlSession.selectOne(namespace+".idChk", memberVo.getUserId());
		memberVo.setIdChk(result);
		return result;
	}

	@Override
	public List<MemberVo> memberList() {
		sqlSession.selectList(namespace+".memberList");
		return sqlSession.selectList(namespace+".memberList");
		
	}

	@Override
	public MemberVo getMember(String userId) {
		sqlSession.selectOne(namespace+".getMember", userId);
		return sqlSession.selectOne(namespace+".getMember", userId);
	}

	@Override
	public int saveMemberInfo(MemberVo memberVo) {
		sqlSession.update(namespace+".saveMemberInfo", memberVo);
		return sqlSession.update(namespace+".saveMemberInfo", memberVo);
	}

	@Override
	public List<Map> getMemberList(Pagination pagination) throws Exception {
		System.out.println("pagination option:"+pagination.getStartIndex()+", "+pagination.getPageSize());
		
		List<Map> map = sqlSession.selectList(namespace+".getMemberList", pagination);
		
		return map;
	}
	
	@Override
	public List<Map> getMemberListAuthority() throws Exception {
		
		List<Map> map = sqlSession.selectList(namespace+".getMemberListAuthority");
		
		return map;
	}
	
	@Override
	public void insertUserPower(Map map) {
		sqlSession.insert(namespace+".insertUserPower", map);
	}

	@Override
	public int upAuthority(String userId) throws Exception {
		return sqlSession.update(namespace+".upAuthority",userId);
	}

	@Override
	public int authorityIdChk(String selectId) {
		return sqlSession.selectOne(namespace+".authorityIdChk", selectId);
	}

	@Override
	public int authorityDeleteChk(Map map) {
		return sqlSession.selectOne(namespace+".authorityDeleteChk", map);
	}

	@Override
	public int deleteAuthorityId(String selectId) {
		return sqlSession.delete(namespace+".deleteAuthorityId",selectId);
		
	}

	@Override
	public int updateUserPassWord(Map map) {
		return sqlSession.update(namespace+".updateUserPassWord", map);
	}

	@Override
	public MemberVo getUserInfo(String userId) {
		MemberVo memberVo = new MemberVo();
		/*
		Map<String,Object>map = new HashMap<>();
		map = sqlSession.selectOne(namespace+".getUserInfo",userId);
		if(map==null) {
			return memberVo;
		}
		memberVo.setUserId((String)map.get("USERID"));
		memberVo.setUserPhoneNum((String)map.get("TEL"));
		memberVo.setUserPw((String)map.get("PASSWD"));
		memberVo.setUserEmail((String)map.get("EMAIL"));
		memberVo.setPower((int)map.get("POWER"));
		memberVo.setUserName((String)map.get("USERNM"));
		return memberVo;
		*/
		memberVo = sqlSession.selectOne(namespace+".getUserInfo", userId);
		return memberVo;
	}

	@Override
	public int memberModify(Map map) {
		return sqlSession.update(namespace+".memberModify", map);
	}
	 
}