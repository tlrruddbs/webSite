package org.hello.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hello.controller.SVCController;
import org.hello.service.BoardService;
import org.hello.service.CommonCodeService;
import org.hello.vo.CommonCodeVo;
import org.hello.vo.MemberVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/svc" })
public class SVCController {
	@Inject
	CommonCodeService commonCodeService;

	@Inject
	BoardService boardService;
	
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = { "member/main" }, method = { RequestMethod.GET, RequestMethod.GET })
	public ModelAndView main(MemberVo memberVo, Model model, HttpServletRequest request,
			@RequestParam(value = "loginResult", defaultValue = "") String loginResult) throws Exception {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 없습니다.");
			mav.setViewName("redirect:/login");
		} else {
			if (loginResult.equals("no")) {
				mav.setViewName("redirect:/login");
				session.setAttribute("msg", "no");
				return mav;
			}
			if ("NoSession" == session.getAttribute("msg")) {
				mav.setViewName("redirect:/login");
				session.setAttribute("msg", "no");
			} else if (session.getAttribute("user") == null) {
				System.out.println("회원정보가 없습니다.");
				session.setAttribute("msg", "NoSession");
				mav.setViewName("redirect:/login");
			} else {
				memberVo = (MemberVo) session.getAttribute("user");

				mav.addObject("memberVo", memberVo);
				System.out.println("/main page 입니다.");
				

			}
		}
		return mav;
	}

	@RequestMapping(value = { "/logout" }, method = { RequestMethod.POST, RequestMethod.GET }, produces = {
			"application/json; charset=utf-8" })
	@ResponseBody
	public ModelAndView logout(HttpServletRequest request) {
		System.out.println("logout!!");
		ModelAndView mav = new ModelAndView();
		request.getSession().removeAttribute("user");
		mav.setViewName("redirect:/login");
		return mav;
	}
}

