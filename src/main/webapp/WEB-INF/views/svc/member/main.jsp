<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head profile="http://www.w3.org/2005/10/profile">
	<link rel="icon" type="image/png" href="http://example.com/myicon.png">


	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/resources/js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/resources/css/custom.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	
	<script>

	
	var msg = "${msg}";
	<%--	var transferMsg = "${transferMsg}"; --%>
		
	
	var transferMsg = getParameterByName('transferMsg');
	
	
	if(transferMsg == "success"){
		alert("메일을 성공적으로 보냈습니다.");
		document.location.href="/svc/member/main"
	} else if(transferMsg=="fail"){
		alert("메일 전송이 실패하였습니다.");
		document.location.href="/svc/member/main"
	}
	if(msg== "NoSession"){
		alert("로그인 후 이용해주세요.");
		location.href = "/login";
	} 
	
	
	function reload(){
		location.reload();
	}
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	</script>
</head>

<body>
	<style type = "text/css">
			.jumbotron{
				background-image:url('/resources/images/background.jpg');
				background-size:cover;
				color:black;
				
			}
			.flex-container{ 
			width: 100%; height: 60vh; display: -webkit-box; display: -ms-flexbox; display: flex; -webkit-box-align: center; -ms-flex-align: center; align-items: center; -webkit-box-pack: center; -ms-flex-pack: center; justify-content: center; 
			} 
			
		}
		</style>

		<nav class="navbar navbar-expand-lg "> 
		<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
		    <img src="/resources/images/Logo.png" width="100" height="50%" style="cursor:pointer" onclick="reload();"/>
		    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse">
      
    	</div>
	
		<div id="navbarNavAltMarkup">
		    <div align="right" class="nav navbar-nav navbar-right" >	
		    <div class="collapse navbar-collapse">
		  		<a class="nav-item nav-link text-dark" href="/svc/member/myPage" >My Page</a>
		      	<a class="nav-item nav-link text-dark" href="/board/listAll" >Board</a>
		   		<a class="nav-item nav-link text-dark" href="/svc/fileDownload">Read me</a>
		   		<a class="nav-item nav-link text-dark" href="/svc/mail/mailForm">Recruit </a>
	    		<a class="nav-item nav-link text-dark" href="/svc/logout" >Logout</a>
	    	</div>
	 	</div> 
		</nav>
		
		
		<div class="jumbotron" > 
			<div class="container" role="main">
			<div class="flex-container"> 
				<div align = "center"; border:1px solid white;>
					<h2 class = "nav-item nav-link text-dark">Seoul, Korea</h1>
					<br>
					<h2 class = "nav-item nav-link text-dark">${memberVo.temp}°C</h1>
					<h2 class = "nav-item nav-link text-dark">${memberVo.weather}</h1>
					
				</div>
				</div>
				<%--
				<div style='width:25%; height:330px;float:right; border:1px solid white;'>
					<h4 class = "nav-item nav-link text-light" align="center">${memberVo.memberCodeString }</h1>
					<h4 class = "nav-item nav-link text-light" align="center">${memberVo.userName }</h1>
					<h4 class = "nav-item nav-link text-light" align="center">${memberVo.userEmail }</h1>
					<h4 class = "nav-item nav-link text-light" align="center"><a href="/board/myBoardList"> ${memberVo.myBoardCountList }</a></h4>
					
					
				</div>
				 --%>
				
				<div class="column_left">
				</div>
				
				<div class="column_right">
					
	  			</div>
	  			
	  		</div>
		</div>


	
	
</body> 
</html>