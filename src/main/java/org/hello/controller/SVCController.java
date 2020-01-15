package org.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/svc")
public class SVCController {
	@RequestMapping(value="member/main", method= {RequestMethod.GET,RequestMethod.GET})
	public ModelAndView main(MemberVo memberVo, Model model, HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(null==session) {
			System.out.println("세션끝남");
			mav.setViewName("redirect:/login");
		} else {
			System.out.println("/main page 입니다.");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value="admin/adminMain", method= {RequestMethod.GET,RequestMethod.GET})
	public ModelAndView adminMain(MemberVo memberVo, Model model, HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(null==session) {
			System.out.println("세션끝남");
			mav.setViewName("redirect:/login");
		} else {
			System.out.println("/adminMain page 입니다.");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value="/logout", method= {RequestMethod.POST, RequestMethod.GET}, produces="application/json; charset=utf-8")
	@ResponseBody 
	public ModelAndView logout(HttpServletRequest request){
		System.out.println("logout!!");
		ModelAndView mav = new ModelAndView();
		request.getSession().removeAttribute("user");
		mav.setViewName("redirect:/login");
		return mav;
	}
}