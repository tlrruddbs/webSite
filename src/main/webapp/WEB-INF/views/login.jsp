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
			.jumbotron{
				background-image:url('/resources/images/main.png');
				background-size:cover;
				text-shadow: black 0.2em 0.2em 0.2em;
				color:black;
				
			}
		</style>

		<nav class="navbar navbar-expand-lg navbar-dark"> 
		<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
		    <img src="/resources/images/logo.png" style="cursor:pointer"  width="100" height="50" onclick="reload();"/>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">	
		  <%--    	<a class="nav-item nav-link active text-light" href="#" >Home <span class="sr-only">(current)</span></a> --%>
		      	<a class="nav-item nav-link text-light" href="/board/listAll" >자유게시판</a>
		      	<a class="nav-item nav-link text-light" onclick="reload();" >로그인</a>
		      	<a class="nav-item nav-link text-light" href="/member/memberRegister">회원가입</a>
		      <%--
			     <div class="dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  text-align="right">
			          	로그인
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				        <a class="dropdown-item" href="#">로그인</a>
				        <a class="dropdown-item" href="#">회원가입</a>
		    	    </div>
	      		</div>
	      		 --%>
	    	</div>
	 	</div>
		</nav>
		
		
		<c:set var ="loginMsg" value = "${loginMsg }"/>
		<c:if test = "${ loginMsg eq 'There is no member information'}">
		<%-- 	out.println("<script>alert("There is no member information");</script>");--%>
			<script>alert("There is no member information"); </script>
		</c:if>
		
		<div class="jumbotron" >
			<div class="container" role="main">
				<div style='width:25%; height:330px;float:right; '>
			<h2><p class="text-light"> LOGIN</p></h2>
					
				<div class="column_left">
				</div>
				
				<div class="column_right">
					
	  			</div>
	  			</div>
	  		</div>
		</div>



	
	
</body> 
</html>