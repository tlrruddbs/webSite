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
<title>Insert title here</title>
	
	
 
</head>
<script>
	function back(){
		history.back();
	}
</script>
<body>
	<style type = "text/css">
		.jumbotron{
			background-image:url('/resources/images/background.jpg');
			background-size:cover;
			color:black;
		}
		.flex-container{ 
		width: 100%; height: 70vh; display: -webkit-box; display: -ms-flexbox; display: flex; -webkit-box-align: center; -ms-flex-align: center; align-items: center; -webkit-box-pack: center; -ms-flex-pack: center; justify-content: center;"; 
		}
		.line{
		border-bottom:1px solid gray;
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
	      	<a class="nav-item nav-link text-dark" href="/board/listAll" >board</a>
	   		<a class="nav-item nav-link text-dark" href="/svc/fileDownload">Read me</a>
	   		<a class="nav-item nav-link text-dark" href="/svc/mail/mailForm">Recruit </a>
	   		<a class="nav-item nav-link text-dark" href="/board/myBoardList">My page </a>
    		<a class="nav-item nav-link text-dark" href="/svc/logout" >Logout</a>
    	</div>
 	</div> 
	</nav>

	<div class="jumbotron" >
		<div class="container">
		 
		 	<div class="flex-container" style="background-color:#ffffff"> 
		 	
		 		<div width="900"  >
		 		
				<table border="0" width="900">
					<tr>
						<th style = "width:10%">번호</th>
						<th style = "width:30%">제목</th>
						<th style = "width:20%">아이디</th>
						<th style = "width:20%">날짜</th>
						<th style = "width:20%">조회수</th>
					</tr>
					
				<%--	<c:forEach items = "${boardList}" var = "boardVo"> --%> 
					<c:forEach items = "${boardList}" var = "boardVo" varStatus="status">
					<tr class="line">
					<%--	<td>${status.count }</td> --%>
						<td>${listCnt-(page.startIndex + status.count)+1 }</p></td>
					 	<td><a href="/board/detail?seq=${boardVo.seq }&id=${boardVo.writer}">${boardVo.title }</a></td>
						<td>${boardVo.writer }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.date }"/></td>
						<td><span>${boardVo.count }</span></td>
					</tr>
			
					</c:forEach>	
				</table>
			</div>
				
		 </div>
	

	
</body>
</html>