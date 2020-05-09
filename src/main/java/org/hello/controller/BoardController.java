package org.hello.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hello.controller.utils.Pagination;
import org.hello.service.BoardService;
import org.hello.vo.BoardVo;
import org.hello.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/board/"})
public class BoardController {
  @Autowired
  private BoardService service;
  
  @RequestMapping(value = {"/create"}, method = {RequestMethod.GET})
  public ModelAndView createGET(BoardVo boardVo, Model model, HttpServletRequest request) throws Exception {
    ModelAndView mav = new ModelAndView();
    System.out.println("/board/crate" );
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      System.out.println("No session");
      session.setAttribute("msg", "NoSession");
      mav.setViewName("/svc/member/main");
    } else {
      System.out.println("session not null");
      MemberVo memberVo = (MemberVo)session.getAttribute("user");
      System.out.println(memberVo.getUserName());
      mav.setViewName("/board/create");
      mav.addObject("member", memberVo);
    } 
    return mav;
  }
  
  @RequestMapping(value = {"/create"}, method = {RequestMethod.POST})
  public ModelAndView createPOST(BoardVo boardVo, ModelAndView mav, HttpServletRequest request) throws Exception {
    System.out.println(boardVo.toString());
    List<BoardVo> boardList = new ArrayList<>();
    this.service.create(boardVo);
    boardList = this.service.listAll();
    mav.addObject("boardList", boardList);
    mav.setViewName("redirect:/board/listAll");
    return mav;
  }
  
  @RequestMapping(value = {"/myBoardList"}, method = {RequestMethod.POST, RequestMethod.GET})
  public ModelAndView myList(BoardVo boardVo, ModelAndView mav, HttpServletRequest request) throws Exception {
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      System.out.println("No session");
      session.setAttribute("msg", "NoSession");
      mav.setViewName("/svc/member/main");
    } else {
      MemberVo memberVo = (MemberVo)session.getAttribute("user");
      List<BoardVo> boardList = new ArrayList<>();
      boardList = this.service.myBoardList(memberVo.getUserId());
      mav.addObject("boardList", boardList);
      mav.addObject("listCnt", Integer.valueOf(boardList.size()));
      System.out.println("listCnt:" + boardList.size());
      mav.setViewName("board/myBoardList");
      for (int i = 0; i < boardList.size(); i++)
        System.out.println(((BoardVo)boardList.get(i)).toString()); 
    } 
    return mav;
  }
  
  @RequestMapping(value = {"/adminListAll"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"text/html; charset=UTF-8"})
  public ModelAndView adminListAll(Model model, HttpServletRequest request, @RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "") String keyWord, @RequestParam(defaultValue = "1") int curPage) throws Exception {
    ModelAndView mav = new ModelAndView();
    Map<String, Object> map = new HashMap<>();
    map.put("searchType", type);
    map.put("searchKeyWord", keyWord);
    HttpSession session = request.getSession();
    List<BoardVo> boardList = new ArrayList<>();
    int listSize = this.service.getBoardListCnt(map);
    Pagination page = new Pagination(listSize, curPage);
    map.put("page", page);
    boardList = this.service.searchList(map);
    mav.addObject("boardList", boardList);
    if (this.service.searchList(map).isEmpty()) {
      System.out.println("search is null");
      this.service.listAll();
      boardList = this.service.getBoardList(page);
      mav.addObject("boardList", boardList);
      mav.addObject("msg", "listEmpty");
    } 
    mav.addObject("listCnt", Integer.valueOf(boardList.size()));
    mav.addObject("page", page);
    return mav;
  }
  
  @RequestMapping(value = {"/listAll"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"text/html; charset=UTF-8"})
  public ModelAndView listAll(Model model, HttpServletRequest request, @RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "") String keyWord, @RequestParam(defaultValue = "1") int curPage) throws Exception {
    ModelAndView mav = new ModelAndView();
    Map<String, Object> map = new HashMap<>();
    map.put("searchType", type);
    map.put("searchKeyWord", keyWord);
    HttpSession session = request.getSession();
    List<BoardVo> boardList = new ArrayList<>();
    int listSize = this.service.getBoardListCnt(map);
    Pagination page = new Pagination(listSize, curPage);
    map.put("page", page);
    boardList = this.service.searchList(map);
    mav.addObject("boardList", boardList);
    if (this.service.searchList(map).isEmpty()) {
      System.out.println("search is null");
      this.service.listAll();
      boardList = this.service.getBoardList(page);
      mav.addObject("boardList", boardList);
      mav.addObject("msg", "listEmpty");
    } 
    mav.addObject("listCnt", Integer.valueOf(boardList.size()));
    mav.addObject("page", page);
    return mav;
  }
  
  @RequestMapping(value = {"/detail"}, method = {RequestMethod.GET})
  public void detail(@RequestParam("seq") int seq, @RequestParam("id") String id, Model model, HttpServletRequest request) throws Exception {
    HttpSession session = request.getSession();
    System.out.println("seq " + seq + "detail" );
    BoardVo boardVo = new BoardVo();
    this.service.plusCnt(seq);
    boardVo = this.service.read(seq);
    System.out.println(String.valueOf(boardVo.getSeq()) + ", " + boardVo.getContent());
    model.addAttribute("board", this.service.read(seq));
    session.setAttribute("idChk", "false");
    if (session.getAttribute("user") != null) {
      MemberVo memberVo = (MemberVo)session.getAttribute("user");
      System.out.println("member user id :" + memberVo.getUserId());
      if (id.equals(memberVo.getUserId()))
        session.setAttribute("idChk", "true"); 
    } 
  }
  
  @RequestMapping(value = {"/updateRequest"}, method = {RequestMethod.GET})
  public void updateRequest(@RequestParam("seq") int seq, Model model) throws Exception {
    System.out.println("update: " + seq);
    BoardVo boardVo = new BoardVo();
    boardVo = this.service.read(seq);
    model.addAttribute("board", this.service.read(seq));
  }
  
  @RequestMapping(value = {"/update"}, method = {RequestMethod.POST})
  public ModelAndView update(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("seq") int seq, HttpServletRequest request, Model model) throws Exception {
    ModelAndView mav = new ModelAndView();
    HttpSession session = request.getSession();
    List<BoardVo> boardList = new ArrayList<>();
    BoardVo boardVo = new BoardVo();
    boardVo.setSeq(seq);
    boardVo.setTitle(title);
    boardVo.setContent(content);
    int num = this.service.update(boardVo);
    if (num > 0) {
      boardVo.setResultMsg("modify success");
      session.setAttribute("msg", "ModifySuccess");
    } else {
      boardVo.setResultMsg("modify fail");
    } 
    boardList = this.service.listAll();
    mav.addObject("boardList", boardList);
    mav.setViewName("redirect:/board/listAll");
    return mav;
  }
}