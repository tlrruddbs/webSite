package org.hello.controller;

import javax.servlet.http.HttpServletRequest;

import org.hello.service.MemberService;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/memberRegister", method= {RequestMethod.POST, RequestMethod.GET})
	public void memberRegister(MemberVo memberVo, Model model)throws Exception{
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView register(MemberVo memberVo, Model model, RedirectAttributes redirectAttributes)throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("register : "+memberVo.toString());
		memberService.insertMember(memberVo);
		mav.addObject("msg", "REGISTERED");
		mav.setViewName("redirect:/svc/admin/adminMain");
		return mav;
	}   
	
	@RequestMapping(value="/idChk", method= {RequestMethod.POST, RequestMethod.GET}, produces="application/json; charset=utf-8")
	@ResponseBody 
	public MemberVo idChk(@RequestBody MemberVo memberVo, HttpServletRequest request) throws Exception{
		
		int result = memberService.idChk(memberVo);
		
		System.out.println("result:"+result);
		if(result>0) {
			System.out.println("중복.");
		} else {
			System.out.println("중복 아님.");
		}   
		   
		return memberVo;
	}
	

	
}
