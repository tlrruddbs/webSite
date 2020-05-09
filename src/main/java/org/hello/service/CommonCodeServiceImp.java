package org.hello.service;

import javax.inject.Inject;
import org.hello.dao.CommonCodeDAO;
import org.hello.service.CommonCodeService;
import org.hello.vo.CommonCodeVo;
import org.springframework.stereotype.Service;

@Service
public class CommonCodeServiceImp implements CommonCodeService {
	@Autowired
	private CommonCodeDAO dao;
  
	public String commonCode(String codeValue) {
		String code = "";
		String commonCode = this.dao.commonCode(codeValue);
		if (commonCode == null)
			return code; 
		code = commonCode;
		return code;
	} 
   
	public String commonCodeValue(String code) {
		System.out.println("commonCodeSerivce: "+code);
		String codeValue = "";
		String commonCodeValue = this.dao.commonCodeValue(code);
		if (commonCodeValue == null)
			return codeValue; 
		codeValue = commonCodeValue;
		System.out.println("codeValue: "+codeValue);
		return codeValue;
	}
}
