package org.hello.service;

import java.util.List;
import java.util.Map;
import org.hello.dao.StationDAO;
import org.hello.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImp implements StationService {
  @Autowired
  private StationDAO dao;
  
  public List<Map> stationList() throws Exception {
    return this.dao.stationList();
  }
  
  public String stationName(int seq) throws Exception {
    return this.dao.stationName(seq);
  }
}
