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
  
	public CommonCodeVo commonCode(String codeValue) {
	    this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCode", codeValue);
	    return (CommonCodeVo)this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCode", codeValue);
	}
  
	public CommonCodeVo commonCodeValue(String code) {
		this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCodeValue", code);
		return (CommonCodeVo)this.sqlSession.selectOne(String.valueOf(namespace) + ".commonCodeValue", code);
	}
}  
 