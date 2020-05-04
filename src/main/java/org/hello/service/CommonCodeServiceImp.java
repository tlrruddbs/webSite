package org.hello.service;

import javax.inject.Inject;
import org.hello.dao.CommonCodeDAO;
import org.hello.service.CommonCodeService;
import org.hello.vo.CommonCodeVo;
import org.springframework.stereotype.Service;

@Service
public class CommonCodeServiceImp implements CommonCodeService {
	@Inject
	private CommonCodeDAO dao;
  
	public String commonCode(String codeValue) {
		String code = "";
		CommonCodeVo commonCodeVo = this.dao.commonCode(codeValue);
		if (commonCodeVo == null)
			return code; 
		code = commonCodeVo.getCode();
		return code;
	} 
   
	public String commonCodeValue(String code) {
		String codeValue = "";
		CommonCodeVo commonCodeVo = this.dao.commonCode(code);
		if (commonCodeVo == null)
			return codeValue; 
		codeValue = commonCodeVo.getCode();
		return codeValue;
	}
}
