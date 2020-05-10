<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/resources/js"></script>
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/resources/css/custom.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<script>
	 
	var msg = "${msg}";
	if(msg== "REGISTERED"){
		alert("회원가입이 완료되었습니다. 로그인해주세요");
	} else if (msg=="NoUser"){
	} else if (msg=="Failure"){
		alert("아이디와 비밀번호를 확인해주세요");
		<%
			session.invalidate();
		%>
	} else if (msg=="Stop"){
		alert("일시 정지된 ID입니다. 관리자에게 문의해주세요");
	} else if (msg=="Ban"){
		alert("영구 정지된 ID입니다. 관리자에게 문의해주세요");
	} else if (msg=="Leave"){
		alert("탈퇴한 회원입니다.");
	} else if (msg=="NoSession"){
		alert("로그인 후 이용해주세요.");
	}  
	 
	function reload(){
		location.href = "/login";
	}
	
</script>
</head>

<body>
	<style type = "text/css">
			.flex-container{ 
			width: 100%; height: 80vh; display: -webkit-box; display: -ms-flexbox; display: flex; -webkit-box-align: center; -ms-flex-align: center; align-items: center; -webkit-box-pack: center; -ms-flex-pack: center; justify-content: center; 
			} 
			.logoBox { 
			width: 25%; height: 60vh;
			background-image: url(/resources/images/log-inWG.png); 
			text-align: center; padding: 2em; 
			}
			.settingForm{
				width: 25%; height: 50vh;
				text-align: center; padding: 2em; 
			}

			.jumbotron{
				background-image:url('/resources/images/background.jpg');
				background-size:cover;
				color:black;
			}
		</style>
		<c:set var ="loginMsg" value = "${loginMsg }"/>
		<c:if test = "${ loginMsg eq 'There is no member information'}">
		<%-- 	out.println("<script>alert("There is no member information");</script>");--%>
			<script>alert("There is no member information"); </script>
		</c:if>
		
		<div class="jumbotron" >
			<div class="container" role="main">
				<div class="flex-container"> 
				<div class="logoBox">
					<div class="settingForm" style="padding-top:120px;">
					<form action="/login/loginRequest" id="login-form" method="post"  >
					 	<div>
					        <input type="text" name="userId" placeholder="ID" id="userId" autofocus>
					    </div>
					    <div class="form-group" style="padding-top:15px">
					        <input type="password" id = "userPw" name="userPw" placeholder="PASSWORD" oninput="checkPwd()">
					    </div>
					    
					    <div style="align:center;">
					    	<a href="#" onclick="document.getElementById('login-form').submit();"><img src="/resources/images/log-in botton_login.png" style="width:170px; height:35px;" /></a>
					    	
					    	

					        
					        <%--
					        <button type="button" class="btn btn-outline-light" onclick="location.href='/member/memberRegister' ">회원가입</button>
					    	--%>
					    </div>
					    <div style="padding-top:120px;">
					    	<a href="/member/memberRegister"><img src="/resources/images/log-in botton_signin.png" style="width:170px; height:35px;" /></a>
					    </div>
					   
					     
				    <div> 
				    </form>
				
				</div> 
				</div>

				<%--
				<div style='width:25%; height:330px;float:right; '>
			<h2><p class="text-light"> LOGIN</p></h2>
				
					<!-- 네이버 로그인 창으로 이동 -->
					<div id="naver_id_login" style="text-align:center"><a href="${url}">
					<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
					<br>

			
					<form action="/login/loginRequest" id="login-form" method="post" >
					 	<div>
					        <input type="text" name="userId" placeholder="id" id="userId" autofocus>
					    </div>
					    <div class="form-group">
					        <input type="password" id = "userPw" name="userPw" placeholder="Password" oninput="checkPwd()">
					    </div>
					    <div>
					        <button type="submit" class="btn btn-outline-light">로그인</button>
					        <!-- signupbtn" disabled="disabled" -->
					        <button type="button" class="btn btn-outline-light" onclick="location.href='/member/memberRegister' ">회원가입</button>
					    </div>
				         
				    </form>
				<div class="column_left">
				</div>
				
				<div class="column_right">
					
	  			</div>
	  			 --%>
	  			</div>
	  		</div>
		</div>



	
	
</body> 
</html>