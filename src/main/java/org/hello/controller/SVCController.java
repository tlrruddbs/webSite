package org.hello.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hello.controller.SVCController;
import org.hello.service.CommonCodeService;
import org.hello.vo.MemberVo;
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
@RequestMapping({"/svc"})
public class SVCController {
  @Inject
  CommonCodeService commonCodeService;
  
  @Autowired
  private JavaMailSender mailSender;
  
  @RequestMapping(value = {"member/main"}, method = {RequestMethod.GET, RequestMethod.GET})
  public ModelAndView main(MemberVo memberVo, Model model, HttpServletRequest request, @RequestParam(value = "loginResult", defaultValue = "") String loginResult) throws Exception {
    ModelAndView mav = new ModelAndView();
    HttpSession session = request.getSession(false);
    if (session == null) {
      System.out.println("세션 끝남");
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
        System.out.println("세션이 없습니다.");
        session.setAttribute("msg", "NoSession");
        mav.setViewName("redirect:/login");
      } else {
    	  memberVo = (MemberVo) session.getAttribute("user");
    	  
    	  mav.addObject("memberVo", memberVo);
        System.out.println("/main page 입니다" );
        System.out.println(memberVo.getUserId());
      } 
    } 
    return mav;
  }
  
  @RequestMapping(value = {"/logout"}, method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json; charset=utf-8"})
  @ResponseBody
  public ModelAndView logout(HttpServletRequest request) {
    System.out.println("logout!!");
    ModelAndView mav = new ModelAndView();
    request.getSession().removeAttribute("user");
    mav.setViewName("redirect:/login");
    return mav;
  }
  
  @RequestMapping({"/mail/mailForm"})
  public String mailForm() {
    return "/svc/mail/mailForm";
  }
  
  @RequestMapping({"/mail/mailSending"})
  public ModelAndView mailSending(HttpServletRequest request, MultipartFile uploadfile) throws IOException {
    ModelAndView mav = new ModelAndView();
    String result = "";
    result = uploadfile.getOriginalFilename();
    System.out.println("getOriginalFileName() :" + result);
    if (result.equals("")) {
      System.out.println("파일 업로드가 없습니다");
    } else {
      result = saveFile(uploadfile);
    } 
    String setfrom = "tlrruddbs@gmail.com";
    String email = request.getParameter("email");
    String title = request.getParameter("title");
    String name = request.getParameter("name");
    String phoneNum = request.getParameter("phoneNum");
    String content = request.getParameter("content");
    String job = request.getParameter("job");
    System.out.println(String.valueOf(job) + ", " + email + ", " + title + ", " + name + ", " + phoneNum + ", " + content);
    content = "" + title + "\n" + "" + name + "\n" + "" + phoneNum + "\n" + "" + job + "\n" + "" + content;
    try {
      MimeMessage message = this.mailSender.createMimeMessage();
      MimeMessageHelper messageHelper = 
        new MimeMessageHelper(message, true, "UTF-8");
      messageHelper.setFrom(setfrom);
      messageHelper.setTo(email);
      messageHelper.setSubject(title);
      messageHelper.setText(content);
      this.mailSender.send(message);
      System.out.println("메일 보내기 성공");
      mav.addObject("transferMsg", "success");
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("메일 보내기 실패");
      mav.addObject("transferMsg", "fail");
    } 
    mav.setViewName("redirect:/svc/member/main");
    return mav;
  }
  
  @RequestMapping({"/fileDownload"})
  public void fileDownload(HttpServletResponse response, HttpServletRequest request) {
    System.out.println("fileDownLoad");
    String path = "/home/fileDownload/readMe.txt";
    String fileName = "readMe.txt";
    File file = new File(path);
    FileInputStream fileInputStream = null;
    ServletOutputStream servletOutputStream = null;
    try {
      String downName = null;
      String browser = request.getHeader("User-Agent");
      if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
        downName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
      } else {
        downName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
      } 
      response.setHeader("Content-Disposition", "attachment;filename=\"" + downName + "\"");
      response.setContentType("application/octer-stream");
      response.setHeader("Content-Transfer-Encoding", "binary;");
      fileInputStream = new FileInputStream(file);
      servletOutputStream = response.getOutputStream();
      byte[] b = new byte[1024];
      int data = 0;
      while ((data = fileInputStream.read(b, 0, b.length)) != -1)
        servletOutputStream.write(b, 0, data); 
      servletOutputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (servletOutputStream != null)
        try {
          servletOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }  
      if (fileInputStream != null)
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }  
    } 
  }
  
  private String saveFile(MultipartFile file) throws IOException {
    String saveName = file.getOriginalFilename();
    File saveFile = new File("/home/fileUpload/", saveName);
    try {
      file.transferTo(saveFile);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    } 
    return saveName;
  }
}
