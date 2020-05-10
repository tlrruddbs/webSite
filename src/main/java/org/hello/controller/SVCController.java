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
				
				
				
				//날씨 api 사용  컴마밑으로 다 짜르자
				BufferedReader br = null;
				try {
					String urlstr = "http://api.openweathermap.org/data/2.5/weather?lat=37.56826&lon=126.977829&appid=b4b4a2990dbdcb7d81fc1020af363d50";

					URL url = new URL(urlstr);
					HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
					urlconnection.setRequestMethod("GET");

					br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
					String result = "";
					String line;
					while ((line = br.readLine()) != null) {
						result = result + line + "\n";
					}
					System.out.println("결과: " + result);

					// Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다.
					JSONParser parser = new JSONParser();
					JSONObject obj = (JSONObject) parser.parse(result);
					JSONObject objTemp = (JSONObject) obj.get("main");
					
					double temp = (double) objTemp.get("temp");
					System.out.println(temp);
					
					JSONArray objWeatherParsing = new JSONArray();//(JSONObject) obj.get("weather");
					objWeatherParsing.add(obj.get("weather"));
					
					String str = objWeatherParsing.get(0).toString();
					str = str.replace("[", "");
					str = str.replace("]", "");
					str = str.substring(str.lastIndexOf("},")+1);
					str = str.substring(0);
					System.out.println("json parsing: "+str);
					
					JSONParser parsere = new JSONParser();
					Object object = parser.parse( str );
					JSONObject jsonObj = (JSONObject) object;

					String code = (String) jsonObj.get("main");
					System.out.println("code:" +code);
					/*
					JSONObject objWeather = (JSONObject)parser.parse(str);
					System.out.println("weather is: "+objWeather.get("main"));
					*/
				//	objWeather
				//	JSONObject weather = (JSONObject) objWeather.get(0);
				//	System.out.println("weather: "+weather.toString());
					
					
					
					
					//서울 날씨 첫째자리 반올림
					temp = temp - 273.0;
				    temp = Double.parseDouble(String.format(Locale.KOREAN, "%.1f",temp));
					
					System.out.println("현재온도: "+temp);
					
					Map map = new HashMap<>();
					map.put("name", obj.get("name"));
		//			map.put("weather", objWeather.get("main"));
				
					System.out.println("name to String: "+(String)obj.get("name"));
					System.out.println("temp:" + temp);
					
					int boardCnt = boardService.myBoardCountList(memberVo.getUserId());
					System.out.println("memberVo to string : "+memberVo.toString());
					System.out.println("memberVo.getMemberCode: "+memberVo.getMemberCode());
					
					String commonCodeValue ="";
					commonCodeValue = commonCodeService.commonCodeValue(memberVo.getMemberCode());
					System.out.println("commonCodeValue is : "+commonCodeValue);
					memberVo.setMemberCodeString(commonCodeValue);
					memberVo.setMyBoardCountList(boardCnt);
					memberVo.setTemp(temp);
					memberVo.setWeather(jsonObj.get("main"));
					memberVo.setName(map.get("name"));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

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

	@RequestMapping({ "/mail/mailForm" })
	public String mailForm() {
		return "/svc/mail/mailForm";
	}

	@RequestMapping({ "/mail/mailSending" })
	public ModelAndView mailSending(HttpServletRequest request, MultipartFile uploadfile) throws IOException {
		ModelAndView mav = new ModelAndView();
		String result = "";
		result = uploadfile.getOriginalFilename();
		System.out.println("getOriginalFileName() :" + result);
		if (result.equals("")) {
			System.out.println("첨부파일이 없습니다.");
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
		System.out.println(
				String.valueOf(job) + ", " + email + ", " + title + ", " + name + ", " + phoneNum + ", " + content);
		content = "제목: " + title + "\n" + "이름: " + name + "\n" + "전화번호: " + phoneNum + "\n" + "이메일: " + email + "\n"
				+ "희망분야: " + job + "\n" + "내용: " + content;
		try {
			MimeMessage message = this.mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);
			messageHelper.setTo("tlrruddbs@naver.com");
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			this.mailSender.send(message);
		
			mav.addObject("transferMsg", "success");
		} catch (Exception e) {
			System.out.println(e);
			
			mav.addObject("transferMsg", "fail");
		}
		mav.setViewName("redirect:/svc/member/main");
		return mav;
	}

	@RequestMapping({ "/fileDownload" })
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


/*
 * cyphers api BufferedReader br = null; try{ String urlstr =
 * "https://api.neople.co.kr/cy/players/ca5034e45bc7dc19081159ef3a429f7b?apikey=0nZX55bwTSBsFISt03PMjy64esQniRcD";
 * 
 * CyphersVo cyphersVo = new CyphersVo();
 * 
 * URL url = new URL(urlstr); HttpURLConnection urlconnection =
 * (HttpURLConnection) url.openConnection();
 * urlconnection.setRequestMethod("GET");
 * 
 * br = new BufferedReader(new
 * InputStreamReader(urlconnection.getInputStream(),"UTF-8")); String result =
 * ""; String line; while((line = br.readLine()) != null) { result = result +
 * line + "\n"; } System.out.println("결과: "+result);
 * 
 * //Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. JSONParser parser = new
 * JSONParser(); JSONObject obj = (JSONObject)parser.parse(result);
 * System.out.println("playerId: "+obj.get("playerId"));
 * System.out.println("records: "+obj.get("records"));
 * 
 * 
 * }catch(Exception e){ System.out.println(e.getMessage()); }
 */

