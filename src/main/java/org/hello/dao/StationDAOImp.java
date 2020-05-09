package org.hello.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.hello.dao.StationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StationDAOImp implements StationDAO {
  @Autowired
  private SqlSession sqlSession;
  
  private static String namespace = "org.hello.mapper.StationMapper";
  
  public List<Map> stationList() throws Exception {
    List<Map> map = this.sqlSession.selectList(String.valueOf(namespace) + ".stationList");
    return map;
  }
  
  public String stationName(int seq) throws Exception {
    return (String)this.sqlSession.selectOne(String.valueOf(namespace) + ".stationName", Integer.valueOf(seq));
  }
}
