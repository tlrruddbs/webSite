package org.hello.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hello.service.CommonCodeService;
import org.hello.vo.BoardVo;
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
@RequestMapping("/svc")
public class SVCController {
	@Inject CommonCodeService commonCodeService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="member/main", method= {RequestMethod.GET,RequestMethod.GET})
	public ModelAndView main(MemberVo memberVo, Model model, HttpServletRequest request, @RequestParam(value="loginResult", defaultValue="") String loginResult)throws Exception{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(null==session) {
			System.out.println("세션끝남");
			mav.setViewName("redirect:/login");
		} else if(loginResult.equals("no")){
			mav.setViewName("redirect:/login");
			session.setAttribute("msg", "no");
			return mav;
		} else if("NoSession"==session.getAttribute("msg")) {
			
			mav.setViewName("redirect:/login");
			session.setAttribute("msg", "no");
		} else if(null == session.getAttribute("user")){
			System.out.println("세션이 없습니다.");
			session.setAttribute("msg", "NoSession");
			mav.setViewName("redirect:/login");
		} else {
			System.out.println("/main page 입니다.");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value="/logout", method= {RequestMethod.POST, RequestMethod.GET}, produces="application/json; charset=utf-8")
	@ResponseBody 
	public ModelAndView logout(HttpServletRequest request){
		System.out.println("logout!!");
		ModelAndView mav = new ModelAndView();
		request.getSession().removeAttribute("user");
		mav.setViewName("redirect:/login");
		return mav;
	}
	
	// mailForm
	@RequestMapping(value = "/mail/mailForm")
	public String mailForm() {
	   
	    return "/svc/mail/mailForm";
	}  
	 
	// mailSending 코드
	@RequestMapping(value = "/mail/mailSending")
	public ModelAndView mailSending(HttpServletRequest request, MultipartFile uploadfile) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		String result = "";
		result = uploadfile.getOriginalFilename();
		System.out.println("getOriginalFileName() :"+result);
		if(result.equals("")) {
			System.out.println("파일 업로드가 없습니다.");
		} else {
			result = saveFile(uploadfile);
		}
		
	    String setfrom = "tlrruddbs@gmail.com";         
	    String email  = request.getParameter("email");     // 받는 사람 이메일
	    String title   = request.getParameter("title");      // 제목
	    String name = request.getParameter("name");
	    String phoneNum = request.getParameter("phoneNum");
	    String content = request.getParameter("content");    // 내용
	    String job = request.getParameter("job");
	    
	    System.out.println(job+", "+email+", "+title+", "+name+", "+phoneNum+", "+content);
	    
	    content = "제목: "+title + "\n"+ "이름: "+name + "\n" + "연락처: "+phoneNum +"\n" + "희망분야: "+job+"\n" + "내용: "+content;
	    
	   
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(email);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	      
	      
	     
	      mailSender.send(message);
	      System.out.println("메일 보내기 성공");
	      mav.addObject("transferMsg", "success");
	    } catch(Exception e){
	      System.out.println(e);
	      System.out.println("메일 보내기 실패");
	      mav.addObject("transferMsg", "fail");
	    }
	    mav.setViewName("redirect:/svc/member/main");
	    
	    
	    return mav;
	}
	/*
	@RequestMapping(value="/fileupload", method = RequestMethod.POST)
	public void upload(MultipartFile uploadfile) {
		System.out.println(uploadfile.getName());
		System.out.println(uploadfile.getOriginalFilename());
		System.out.println(uploadfile.getContentType());
		String result = saveFile(uploadfile);
		if(result != null) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
	*/
	
	
	@RequestMapping(value="/fileDownload")
	public void fileDownload( HttpServletResponse response, HttpServletRequest request) {
	 
		System.out.println("fileDownLoad");
		
	//    String path = "C:/tmp/test.txt"; //full경로
		String path = "/home/fileDownload/readMe.txt";
	    String fileName = "readMe.txt"; //파일명
	 
	    File file = new File(path);
	 
	    FileInputStream fileInputStream = null;
	    ServletOutputStream servletOutputStream = null;
	 
	    try{
	        String downName = null;
	        String browser = request.getHeader("User-Agent");
	        //파일 인코딩
	        if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){//브라우저 확인 파일명 encode  
	            
	            downName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
	            
	        }else{
	            
	            downName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	            
	        }
	        
	        response.setHeader("Content-Disposition","attachment;filename=\"" + downName+"\"");             
	        response.setContentType("application/octer-stream");
	        response.setHeader("Content-Transfer-Encoding", "binary;");
	 
	        fileInputStream = new FileInputStream(file);
	        servletOutputStream = response.getOutputStream();
	 
	        byte b [] = new byte[1024];
	        int data = 0;
	 
	        while((data=(fileInputStream.read(b, 0, b.length))) != -1){
	            
	            servletOutputStream.write(b, 0, data);
	            
	        }
	 
	        servletOutputStream.flush();//출력
	        
	    }catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        if(servletOutputStream!=null){
	            try{
	                servletOutputStream.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }
	        if(fileInputStream!=null){
	            try{
	                fileInputStream.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	private String saveFile(MultipartFile file) throws IOException {
		//	UUID uuid = UUID.randomUUID();
		//	String saveName = uuid+"_"+file.getOriginalFilename();
			String saveName = file.getOriginalFilename();
		//	System.out.println("saveName: "+saveName);
		//	File saveFile = new File("C:\\fileUpload",saveName);
		//	File saveFile = new File("/home/fileUpload/11111");
			File saveFile = new File("/home/fileUpload/",saveName);
			/*
			if(!saveFile.exists()){ 
				saveFile.mkdirs(); 
//				Runtime.getRuntime().exec("chmod 777 " + "/home/fileUpload/"+"22222");
				Runtime.getRuntime().exec("chmod 777 " + "C:\\fileUpload"+saveName);
				saveFile.setExecutable(true, false); 
				saveFile.setReadable(true, false); 
				saveFile.setWritable(true, false); 
				System.out.println("newFile.canWrite()>>>>>>>>>>"+ saveFile.canWrite()); 
				System.out.println("newFile.canExecute()>>>>>>>>>>"+ saveFile.canExecute()); 
				saveFile.createNewFile(); 
			}
			*/
			try {
				file.transferTo(saveFile);
			} catch(IOException e) {
				e.printStackTrace();
				return null;
			}
			return saveName;
		}
}