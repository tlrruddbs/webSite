package org.hello.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.hello.dao.CommonCodeDAO;
import org.springframework.stereotype.Repository;

@Repository
public class CommonCodeDAOImp implements CommonCodeDAO {
  @Autowired
  private SqlSession sqlSession;
  
  private static String namespace = "org.hello.mapper.CommonCodeMapper";
   
  public String commonCode(String codeValue) {
    this.sqlSession.selectOne(String.valueOf(String.valueOf(namespace)) + ".commonCode", codeValue);
    return (String)this.sqlSession.selectOne(String.valueOf(String.valueOf(namespace)) + ".commonCode", codeValue);
  }
  
  public String commonCodeValue(String code) {
    System.out.println("commonCodeDAO code: " + code);
    this.sqlSession.selectOne(String.valueOf(String.valueOf(namespace)) + ".commonCodeValue", code);
    return (String)this.sqlSession.selectOne(String.valueOf(String.valueOf(namespace)) + ".commonCodeValue", code);
  }
}
