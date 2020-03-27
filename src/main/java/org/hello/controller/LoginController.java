package org.hello.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

	@RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET})
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
				System.out.println("loginController Nosession");
				session.removeAttribute("msg");
			}
			if (userVo == null) {
				System.out.println("userVo null");
				mav.setViewName("/login");
			} else {
				System.out.println("commonCode :" + userVo.getMemberCode());
				if (userVo.getMemberCode().equals("CMMMCD001")) {
					System.out.println("관리자");
					String url = "";
					if (userVo.getMemberStatus().equals("CMMMST001")) {
						System.out.println("정상회원입니다.");
						session.setAttribute("msg", "Normal");
						url = "redirect:/svc/admin/adminMain";
					} else if (userVo.getMemberStatus().equals("CMMMST002")) {
						System.out.println("일시정지 회원입니다.");
						session.setAttribute("msg", "Normal");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST003")) {
						System.out.println("영구정지 회원입니다.");
						session.setAttribute("msg", "Ban");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST004")) {
						System.out.println("탈퇴한 회원입니다.");
						session.setAttribute("msg", "Leave");
						url = "/login";
					}
					mav.setViewName(url);
				} else {
					System.out.println("회원");
					String url = "";
					if (userVo.getMemberStatus().equals("CMMMST001")) {
						System.out.println("정상회원입니다.");
						session.setAttribute("msg", "Normal");
						url = "redirect:/svc/member/main";
					} else if (userVo.getMemberStatus().equals("CMMMST002")) {
						System.out.println("일시정지 회원입니다.");
						session.setAttribute("msg", "Stop");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST003")) {
						System.out.println("영구정지 회원입니다");
						session.setAttribute("msg", "Ban");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST004")) {
						System.out.println("탈퇴한 회원입니다");
						session.setAttribute("msg", "Leave");
						url = "/login";
					}
					mav.setViewName(url);
				}
			}
		}
		return mav;
  }

	@RequestMapping(value = { "/loginRequest" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginRequest(MemberVo memberVo, Model model, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println(String.valueOf(memberVo.getUserId()) + ", " + memberVo.getUserPw());
		MemberVo userVo = this.loginService.loginRequest(memberVo);
		if (userVo == null || !userVo.getUserPw().equals(memberVo.getUserPw())) {
			userVo = null;
			session.setAttribute("msg", "Failure");
		}
		mav.addObject("userVo", memberVo);
		session.setAttribute("user", userVo);
		session.setMaxInactiveInterval(120);
		mav.setViewName("redirect:/login");
		return mav;
	}
}
