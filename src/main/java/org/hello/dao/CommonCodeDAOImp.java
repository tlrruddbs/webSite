package org.hello.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.dao.CommonCodeDAO;
import org.hello.vo.CommonCodeVo;
import org.springframework.stereotype.Repository;

@Repository
public class CommonCodeDAOImp implements CommonCodeDAO {
	@Inject
	private SqlSession sqlSession;
  
	private static String namespace = "org.hello.mapper.CommonCodeMapper";
  
	public String commonCode(String codeValue) {
	    this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCode", codeValue);
	    return this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCode", codeValue);
	}
  
	public String commonCodeValue(String code) {
		System.out.println("commonCodeDAO code: "+code);
		this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCodeValue", code);
		return this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCodeValue", code);
	}
}  
 