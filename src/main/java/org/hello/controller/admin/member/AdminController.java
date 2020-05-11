package org.hello.controller.admin.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hello.controller.utils.Pagination;
import org.hello.service.MemberService;
import org.hello.service.StationService;
import org.hello.vo.AddVo;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	MemberService memberService;

	@Autowired
	StationService stationService;
	
	//메인화면
	@RequestMapping(value = { "/adminMain" }, method = { RequestMethod.GET, RequestMethod.GET })
	public ModelAndView memberList(MemberVo memberVo, Model model, HttpServletRequest request,
			@RequestParam(defaultValue = "1") int curPage) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
			return mav;
		}
		int listCnt = this.memberService.memberList().size();
		Map<String, Object> map = new HashMap<>();
		Pagination page = new Pagination(listCnt, curPage);
		map.put("page", page);
		
		List<Map> memberList = this.memberService.getMemberList(page);

		mav.addObject("memberList", memberList);
		mav.addObject("listCnt", Integer.valueOf(listCnt));
		mav.addObject("page", page);
		return mav;
	}

	//회원 등록 화면
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
	
	//관할 관리소 등록 화면
	@RequestMapping({ "/memberList/authority" })
	@ResponseBody
	public ModelAndView authority(HttpServletRequest request) throws Exception {
		System.out.println("/memberList/register");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		List<Map> stationList = this.stationService.stationList();
		List<Map> memberAuthorityList = this.memberService.getMemberListAuthority();
		mav.addObject("stationList", stationList);
		mav.addObject("memberAuthorityList", memberAuthorityList);

		mav.setViewName("/svc/admin/authority");
		return mav;
	}

	
	//power 추가
	@RequestMapping({ "/memberList/authority/add" })
	@ResponseBody
	public AddVo authorityAdd(HttpServletRequest request, @RequestBody AddVo addVo) throws Exception {

		System.out.println("/authority/add");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}

		String selectId = addVo.getMemberSelect();
		String strSeq = addVo.getStationSelect();

		int seq = Integer.parseInt(strSeq);

		int idChk = memberService.authorityIdChk(selectId);
		if (idChk > 0) {
			System.out.println("중복된 아이디");
			addVo.setIdChk(idChk);
			return addVo;
		} else {
			addVo.setIdChk(idChk);
		}

		System.out.println("userId: " + selectId);
		System.out.println("statoin SEQ: " + seq);

		String stationName = stationService.stationName(seq);
		System.out.println("station Name: " + stationName);
		Map map = new HashMap<>();
		map.put("userId", selectId);
		map.put("seq", seq);
		map.put("stationName", stationName);

		memberService.insertUserPower(map);
		int authorityChk = memberService.upAuthority(selectId);
		if (authorityChk == 1) {
			System.out.println("memberTable 수정 완료");
			// mav.addObject("authority",upAuthority);
			addVo.setAuthorityChk(authorityChk);
		} else {
			System.out.println("memberTable 수정 실패");
			addVo.setAuthorityChk(authorityChk);
		}

		addVo.setStationList(this.stationService.stationList());
		addVo.setMemberAuthorityList(this.memberService.getMemberListAuthority());

		return addVo;

	}

	//power 삭제
	@RequestMapping({ "/memberList/authority/delete" })
	@ResponseBody
	public AddVo delete(HttpServletRequest request, @RequestBody AddVo addVo) throws Exception {

		System.out.println("/authority/delete");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		}
		String selectId = addVo.getMemberSelect();
		String strSeq = addVo.getStationSelect();
		Map selectMap = new HashMap<>();
		selectMap.put("selectId", selectId);
		selectMap.put("strSeq", strSeq);

		addVo.setIdChk(0);
		addVo.setDeleteChk(0);

		System.out.println(selectId + ", " + strSeq);
		int seq = Integer.parseInt(strSeq);

		int idChk = memberService.authorityIdChk(selectId);
		addVo.setIdChk(idChk);
		if (idChk > 0) {
			int deleteChk = memberService.authorityDeleteChk(selectMap);
			System.out.println("deleteChk: " + deleteChk);
			if (deleteChk > 0) {
				System.out.println("지워도 좋다");
				int deleteCheck = memberService.deleteAuthorityId(selectId);
				System.out.println("deleteCheck:" + deleteCheck);
				addVo.setDeleteChk(deleteCheck);
			} else {
				System.out.println("해당하는게 없다");
			}
		} else {
			System.out.println("아이디가 없습니다");
			addVo.setIdChk(idChk);
			return addVo;
		}
		return addVo;
	}

	//관리자 비밀번호 수정
	@RequestMapping({ "/memberList/passwordModify" })
	@ResponseBody
	public ModelAndView passwordModify(MemberVo memberVo, HttpServletRequest request) throws Exception {
		System.out.println("/memberList/passwordModify");
		HttpSession session = request.getSession();
		MemberVo userVo = (MemberVo) session.getAttribute("user");

		ModelAndView mav = new ModelAndView();

		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		} else if (null == userVo) {
			System.out.println("userVo is null");
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
		} else {
			String userId = "";
			System.out.println("userId: " + userId);
			mav.addObject("userId", userVo.getUserId());
		}
		mav.setViewName("/svc/admin/passwordModify");
		return mav;
	}

	//회원 아이디 클릭시 창
	@RequestMapping({ "/memberList/infoModify" })
	@ResponseBody
	public ModelAndView infoModify(HttpServletRequest request, @RequestParam(defaultValue = "") String userId)
			throws Exception {
		System.out.println("/memberList/infoModify");
		HttpSession session = request.getSession();
		MemberVo userVo = (MemberVo) session.getAttribute("user");

		System.out.println("userId is: " + userId);
		ModelAndView mav = new ModelAndView();

		MemberVo memberVo = null;
		memberVo = this.memberService.getUserInfo(userId);

		System.out.println("userEmail: " + memberVo.getEmail().toString());

		if (session == null) {
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
			return mav;
		} else if (null == userVo) {
			System.out.println("userVo is null");
			System.out.println("세션이 만료되었습니다.");
			mav.setViewName("redirect:/login");
			return mav;
		}
		mav.addObject("memberVo", memberVo);
		mav.addObject("userId", userId);
		mav.setViewName("/svc/admin/infoModify");
		return mav;
	}

	//회원 정보 또는 시스템 관리자 비밀번호 수정 시
	@RequestMapping({ "/memberList/modify" })
	@ResponseBody
	MemberVo modify(@RequestBody Map<String, Object> params, HttpServletRequest request) throws Exception {
		System.out.println("/memberList/modify");

		MemberVo memberVo = new MemberVo();
		memberVo.setModifyChk(0);
		String userId = (String) params.get("userId");
		String passWD = (String) params.get("passWD");
		System.out.println(userId + ", " + passWD);

		memberVo.setUserId(userId);
		memberVo.setPassWD(passWD);
		
		int modifyChk = memberService.updateUserPassWord(memberVo);
		System.out.println("modify Chk: " + modifyChk);

		if (modifyChk > 0) {
			System.out.println("수정완료");
			memberVo.setModifyChk(modifyChk);
		} else {
			System.out.println("수정실패");
			memberVo.setModifyChk(modifyChk);
		}

		return memberVo;
	}
	
	//회원 정보 수정
	@RequestMapping({ "/memberList/memberModify" })
	@ResponseBody
	MemberVo memberModify(@RequestBody MemberVo memberVo, HttpServletRequest request) throws Exception {
		System.out.println("/memberList/memberModify");

		System.out.println("id: " + memberVo.getUserId() + ", power: " + memberVo.getPower() + ", name: " + memberVo.getUserNM() + ", userEmail: " + memberVo.getEmail()
				+ ", passWD: " + memberVo.getPassWD() + ", userPhoneNum: " + memberVo.getTel());

	
		int memberModifyChk = memberService.memberModify(memberVo);

		if (memberModifyChk > 0) {
			System.out.println("사용자 정보수정 완료");
			memberVo.setMemberModifyChk(memberModifyChk);
		} else {
			System.out.println("사용자 정보수정 실패");
			memberVo.setMemberModifyChk(memberModifyChk);
		}

		return memberVo;
	}

	//회원추가
	@RequestMapping({ "/memberList/memberRegister" })
	@ResponseBody MemberVo memberRegister(@RequestBody MemberVo memberVo, HttpServletRequest request) throws Exception {

		System.out.println("/memberList/memberRegister");

		System.out.println("id: " + memberVo.getUserId() + ", power: " + memberVo.getPower() + ", name: " + memberVo.getUserNM() + ", userEmail: " + memberVo.getEmail()
				+ ", passWD: " + memberVo.getPassWD() + ", userPhoneNum: " + memberVo.getTel());


		memberService.insertMember(memberVo);
		memberVo.setMemberRegisterChk(1);
		System.out.println("추가 성공");
		return memberVo;
	}
	//로그아웃
	@RequestMapping(value = { "/logout" }, method = { RequestMethod.POST, RequestMethod.GET }, produces = {
			"application/json; charset=utf-8" })
	@ResponseBody public ModelAndView logout(HttpServletRequest request) {
		System.out.println("logout!!");
		ModelAndView mav = new ModelAndView();
		request.getSession().removeAttribute("user");
		mav.setViewName("redirect:/login");
		return mav;
	}

}
