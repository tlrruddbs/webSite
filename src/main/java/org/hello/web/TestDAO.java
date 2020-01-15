//package org.hello.web;
//
//import javax.inject.Inject;
//
//import org.hello.dao.MemberDAO;
//import org.hello.vo.MemberVo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class TestDAO {
//   
//    @Inject
//    private MemberDAO dao;
//   
//    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
//    public void testDAO(){
//    	System.out.println("aa");
//        MemberVo vo = new MemberVo();
//        vo.setUser_id("MIN-IT8");
//        vo.setUser_pw("1234");
//        vo.setUser_email("qdqwe");
//        vo.setUser_name("���");
//       
//        dao.insertMember(vo);
//    }
//}