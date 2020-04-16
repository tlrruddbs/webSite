package org.hello.dao;

import org.hello.vo.CommonCodeVo;

public interface CommonCodeDAO {
	CommonCodeVo commonCode(String paramString);
  
	CommonCodeVo commonCodeValue(String paramString);
}
  