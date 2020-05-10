package org.hello.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hello.controller.LoginController;
import org.hello.service.LoginService;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/login" })
public class LoginController {
	@Inject
	LoginService loginService;

	@RequestMapping(value = { "" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(MemberVo memberVo, ModelAndView model, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("session null");
		} else {
			String msg = (String) session.getAttribute("loginMsg");
			MemberVo userVo = (MemberVo) session.getAttribute("user");
			String sessionChk = "NoSession";
			if (sessionChk == session.getAttribute("msg")) {
				mav.addObject("msg", "NoSession");
			}
			if (userVo==null) {
				mav.setViewName("/login");
			} 
			else {
				String url = "";
				System.out.println("userPower :" + userVo.getPower());
				if (userVo.getPower()==2) {
					System.out.println("시스템 관리자입니다.");
					
					url = "redirect:/svc/admin/adminMain";
				} else {
					System.out.println("일시정지입니다.");
					mav.addObject("msg", "Stop");
					// session.setAttribute("msg", "Normal");
					url = "/login";
				} 
				mav.setViewName(url);
			} 
			
		}
		return mav;
	}

	@RequestMapping(value = { "/loginRequest" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginRequest(MemberVo memberVo, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = memberVo.getUserId();
		String userPw = memberVo.getPassWD();
		MemberVo userVo = null;  
		userVo = this.loginService.loginRequest(memberVo);
		System.out.println("userVo: "+userVo.toString());
		System.out.println("userVo detail: "+userVo.getTel());
		System.out.println("userVo id"+userVo.getUserId()+", userVoPW: "+userVo.getPassWD()+", memberVo Pw:"+userPw);
		if (userVo.getUserId().equals("") || !userVo.getPassWD().equals(userPw)) {
			userVo = null;
			//mav.addObject("msg","Failure");
			session.setAttribute("msg", "Failure");
		}
		mav.addObject("userVo", memberVo);
		session.setAttribute("user", userVo);
		session.setMaxInactiveInterval(1200);
		mav.setViewName("redirect:/login");
		return mav;
	}
}
