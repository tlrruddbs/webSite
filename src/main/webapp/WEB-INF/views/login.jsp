<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script>
	var msg = "${msg}";
	if(msg== "REGISTERED"){
		alert("회원가입이 완료되었습니다. 로그인해주세요");
	} else if (msg=="FAILURE"){
		alert("아이디와 비밀번호를 확인해주세요");
	} else if (msg=="Stop"){
		alert("일시 정지된 ID입니다. 관리자에게 문의해주세요");
	} else if (msg=="Ban"){
		alert("영구 정지된 ID입니다. 관리자에게 문의해주세요");
	} else if (msg=="Leave"){
		alert("탈퇴한 회원입니다.");
	}
	 
	
	
</script>
<body>
	<c:set var ="loginMsg" value = "${loginMsg }"/>
	<c:if test = "${ loginMsg eq 'There is no member information'}">
	<%-- 	out.println("<script>alert("There is no member information");</script>");--%>
		<script>alert("There is no member information"); </script>
	</c:if>
	<form action="/login/loginRequest" id="login-form" method="post">
	 	<div>
	        <input type="text" name="userId" placeholder="id" id="userId" autofocus>
	    </div>
	    <div>
	        <input type="password" id = "userPw" name="userPw" placeholder="Password" oninput="checkPwd()">
	    </div>
	    <div>
	        <button type="submit">로그인</button>
	        <!-- signupbtn" disabled="disabled" -->
	    </div>
         
    </form>
    <button type="button" onclick="location.href='/member/memberRegister' ">회원가입</button>
</body> 
</html>