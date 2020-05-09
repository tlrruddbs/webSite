package org.hello.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hello.service.MemberService;
import org.hello.vo.AddVo;
import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Inject 
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
		System.out.println("PARAM: "+request.getParameter("userId"));
		
		System.out.println("userId: "+ memberVo.getUserId());
		int result = memberService.idChk(memberVo);
		
		System.out.println("result:"+result);
		if(result>0) {
			System.out.println("중복된 아이디입니다.");
		} else {
			System.out.println("사용가능한 아이디입니다.");
		}
		
		return memberVo;
	}
	

	
}
