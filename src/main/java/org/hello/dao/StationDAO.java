package org.hello.dao;

import java.util.List;
import java.util.Map;

public interface StationDAO {
  List<Map> stationList() throws Exception;
  
  String stationName(int paramInt) throws Exception;
}
