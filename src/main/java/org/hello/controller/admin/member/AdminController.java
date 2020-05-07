package org.hello.controller.admin.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hello.controller.utils.Pagination;
import org.hello.service.CommonCodeService;
import org.hello.service.MemberService;
import org.hello.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/svc/admin" })
public class AdminController {
	@Inject
	MemberService memberService;

	@Inject
	CommonCodeService commonCodeService;

	@RequestMapping(value = { "/adminMain" }, method = { RequestMethod.GET, RequestMethod.GET })
	public ModelAndView memberList(MemberVo memberVo, Model model, HttpServletRequest request,
			@RequestParam(defaultValue = "1") int curPage) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		int listCnt = this.memberService.memberList().size();
		Map<String, Object> map = new HashMap<>();
		Pagination page = new Pagination(listCnt, curPage);
		map.put("page", page);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		List<Map> memberList = this.memberService.getMemberList(page);
		
		mav.addObject("memberList", memberList);
		mav.addObject("listCnt", Integer.valueOf(listCnt));
		mav.addObject("page", page);
		return mav;
	}
	@RequestMapping({ "/memberList/singleMemberView" })
	public ModelAndView singleMemberView(HttpServletRequest request, @RequestParam(defaultValue = "") String userId)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		System.out.println("singleMemberView userId :" + userId);
		MemberVo memberVo = this.memberService.getMember(userId);
		if (memberVo != null) {
			mav.addObject("memberVo", memberVo);
			mav.setViewName("/svc/admin/singleMemberView");
		}
		return mav;
	}
	
	@RequestMapping({ "/memberList/register" })
	public ModelAndView register(HttpServletRequest request) throws Exception {
		System.out.println("/memberList/register");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		mav.setViewName("/svc/admin/register");
		return mav;
	}
/*
	@RequestMapping({ "/memberList/singleMemberView/modifyInfo" })
	@ResponseBody
	public MemberVo modify(HttpServletRequest request, @RequestBody MemberVo memberInfo) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		System.out.println("memberStatus :" + memberInfo.getMemberStatus());
		memberInfo.setMemberStatus(this.commonCodeService.commonCode(memberInfo.getMemberStatus()));
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		MemberVo memberVo = this.memberService.getMember(memberInfo.getUserId());
		if (memberVo.getMemberStatus() != null)
			memberVo.setMemberStatus(memberInfo.getMemberStatus());
		System.out.println("memberStatus:" + memberVo.getMemberStatus());
		int result = this.memberService.saveMemberInfo(memberVo);
		return memberVo;
	}
	*/
}
