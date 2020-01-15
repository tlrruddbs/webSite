package org.hello.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hello.service.BoardService;
import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createGET(BoardVo boardVo, Model model, HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		
		System.out.println("/board/crate 입니다. get방식");
		HttpSession session = request.getSession();
		
		if(null == session.getAttribute("user")) {
			
			mav.setViewName("redirect:/login");
		} else {
			
			System.out.println("session not null");
			MemberVo memberVo = (MemberVo) session.getAttribute("user");
			System.out.println(memberVo.getUserName());
			mav.setViewName("/board/create");
			mav.addObject("member", memberVo);
		
		}
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPOST(BoardVo boardVo, ModelAndView mav, HttpServletRequest request)throws Exception{
	
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		service.create(boardVo);
		boardList = service.listAll();
		mav.addObject("boardList",boardList);
		mav.setViewName("redirect:/board/listAll");
		return mav;
	}
	
	@RequestMapping(value="/myBoardList", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView myList(BoardVo boardVo, ModelAndView mav, HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		
		if(null == session.getAttribute("user")) {
			mav.setViewName("redirect:/login");
		} else {
			MemberVo memberVo = (MemberVo) session.getAttribute("user");
			
			List<BoardVo> boardList = new ArrayList<BoardVo>();
			boardList = service.myBoardList(memberVo.getUserId());
			mav.addObject("boardList",boardList);
			mav.setViewName("board/myBoardList");
			
			for(int i=0;i<boardList.size();i++) {
				System.out.println(boardList.get(i).toString());
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/listAll", method= {RequestMethod.GET, RequestMethod.POST}, produces = "text/html; charset=UTF-8")
	public ModelAndView listAll(Model model, HttpServletRequest request, @RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "") String keyWord) throws Exception{
		
		System.out.println("type :"+type+", keyWord :"+keyWord);
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", type);
		map.put("searchKeyWord", keyWord);
		
		HttpSession session = request.getSession();
		if(null == session.getAttribute("user")) {
			mav.setViewName("redirect:/login");
		}
		System.out.println("전체 목록 페이지");
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList = service.searchList(map);
//		boardList = service.listAll();
		for(int i=0;i<boardList.size();i++) {
			System.out.println(boardList.get(i).toString());
		}
		model.addAttribute("boardList", service.searchList(map));
		if(service.searchList(map).isEmpty()) {
			System.out.println("아무 내용이 없습니다.");
			service.listAll();
			model.addAttribute("boardList", service.listAll());
			mav.addObject("msg", "listEmpty");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(@RequestParam("seq")int seq, @RequestParam("id")String id, Model model, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		System.out.println("글 번호 "+seq+"번의  상세내용 페이지");
		
		BoardVo boardVo = new BoardVo();
		service.plusCnt(seq);
		boardVo = service.read(seq);
		System.out.println(boardVo.getSeq()+", "+boardVo.getContent());
		
		model.addAttribute("board", service.read(seq));
		
		session.setAttribute("idChk", "false");
		
		if (null != session.getAttribute("user")) {
			MemberVo memberVo = (MemberVo) session.getAttribute("user");
			System.out.println("member user id :"+memberVo.getUserId());
			if(id.equals(memberVo.getUserId())) {
				session.setAttribute("idChk", "true");
			}
		}
	}
	
	@RequestMapping(value = "/updateRequest", method = RequestMethod.GET)
	public void updateRequest(@RequestParam("seq")int seq, Model model) throws Exception{
		System.out.println("update: "+seq);
		BoardVo boardVo = new BoardVo();
		boardVo = service.read(seq);
		
		model.addAttribute("board", service.read(seq));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("seq")int seq, Model model) throws Exception{
		ModelAndView mav = new ModelAndView();
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		BoardVo boardVo = new BoardVo();
		boardVo.setSeq(seq);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		int num = service.update(boardVo);
		if(num>0) {
			boardVo.setResultMsg("성공적으로 수정되었습니다.");
		} else {
			boardVo.setResultMsg("수정이 실패하였습니다.");
		}
		boardList = service.listAll();
		mav.addObject("boardList",boardList);
		mav.setViewName("/board/listAll");
		return mav;
	}
}
