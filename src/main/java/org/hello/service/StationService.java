package org.hello.service;

import java.util.List;
import java.util.Map;


public interface StationService {
	public List<Map> stationList() throws Exception;
	
	public String stationName(int seq) throws Exception;
}
