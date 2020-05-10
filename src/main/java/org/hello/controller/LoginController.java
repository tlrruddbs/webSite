package org.hello.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hello.controller.LoginController;
import org.hello.naver.NaverLoginBO;
import org.hello.service.LoginService;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/login" })
public class LoginController {
	@Autowired
	LoginService loginService;

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
	this.naverLoginBO = naverLoginBO;
	}

	
	@RequestMapping(value = { "" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView login(MemberVo memberVo, ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
		
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		//네이버
		mav.addObject("url", naverAuthUrl);
		
		
		if (session == null) {
			System.out.println("session null");
		} else {
			String msg = (String) session.getAttribute("loginMsg");
			MemberVo userVo = (MemberVo) session.getAttribute("user");
			String sessionChk = "NoSession";
			if (sessionChk == session.getAttribute("msg")) {
				mav.addObject("msg", "NoSession");
				// System.out.println("loginController Nosession");
				// session.removeAttribute("msg");
			}
			if (userVo==null) {
				mav.setViewName("/login");
			} 
			/* �궘�젣�븷寃�
			else if (userVo==null) {
				mav.addObject("msg", "NoUser");
				mav.setViewName("/login");
			}
			*/
			/*
			 * if (userVo == null) { System.out.println("userVo null");
			 * mav.addObject("msg","NoUser"); mav.setViewName("/login"); }
			 */
			
			else {
				System.out.println("commonCode :" + userVo.getMemberCode());
				if (userVo.getMemberCode().equals("CMMMCD001")) {
					System.out.println("관리자입니다.");
					String url = "";
					if (userVo.getMemberStatus().equals("CMMMST001")) {
						System.out.println("정상입니다.");
						mav.addObject("msg", "Normal");

						// session.setAttribute("msg", "Normal");
						url = "redirect:/svc/admin/adminMain";
					} else if (userVo.getMemberStatus().equals("CMMMST002")) {
						System.out.println("일시정지입니다.");
						mav.addObject("msg", "Stop");
						// session.setAttribute("msg", "Normal");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST003")) {
						System.out.println("영구정지입니다.");
						mav.addObject("msg", "Ban");
						// session.setAttribute("msg", "Ban");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST004")) {
						System.out.println("탈퇴한 회원입니다.");
						mav.addObject("msg", "Leave");
						// session.setAttribute("msg", "Leave");
						url = "/login";
					}
					mav.setViewName(url);
				} else {
					System.out.println("회원입니다.");
					String url = "";
					if (userVo.getMemberStatus().equals("CMMMST001")) {
						System.out.println("정상입니다.");
						// session.setAttribute("msg", "Normal");
						mav.addObject("msg", "Normal");
						url = "redirect:/svc/member/main";
					} else if (userVo.getMemberStatus().equals("CMMMST002")) {
						System.out.println("일시정지입니다.");
						mav.addObject("msg", "Stop");
						// session.setAttribute("msg", "Stop");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST003")) {
						System.out.println("영구정지입니다.");
						mav.addObject("msg", "Ban");
						// session.setAttribute("msg", "Ban");
						url = "/login";
					} else if (userVo.getMemberStatus().equals("CMMMST004")) {
						System.out.println("탈퇴한 회원입니다.");
						mav.addObject("msg", "Leave");
						// session.setAttribute("msg", "Leave");
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
