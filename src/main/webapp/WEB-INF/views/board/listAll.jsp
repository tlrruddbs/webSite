<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="org.hello.controller.utils.Pagination"%>
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
<title></title>
	
	<head>
	
		
	
	</head>
<script>
	function reload(){
		location.href = "/login";
	}
	function mainPage(){
		location.href="/svc/member/main?loginResult=no";
	}
	function mainPageCheck(){
		location.href="/svc/member/main";
	}

	function searchCheck(frm){
		if(frm.keyWord.value == ""){
			alert("정보가 없습니다.");
			frm.keyWord.focus();
			return;
		}
		frm.submit();
	}
	
	
	
	
	var msg = "${msg}";
	if(msg == "listEmpty"){
		alert("정보가 없습니다.");
		location.href="/board/listAll";

	} else if(msg=="ModifySuccess"){
		alert("수정 완료")
	}
	
	function fn_paging(curPage) {
		location.href = "/board/listAll?curPage=" + curPage;
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
			width: 100%; height: 70vh; display: -webkit-box; display: -ms-flexbox; display: flex; -webkit-box-align: center; -ms-flex-align: center; align-items: center; -webkit-box-pack: center; -ms-flex-pack: center; justify-content: center;"; 
			}
			.line{
			border-bottom:1px solid gray;
			}
			.form-inline {
		      vertical-align: right;
		    }
	</style>

	<nav class="navbar navbar-expand-lg navbar-dark"> 
	<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
	    <img src="/resources/images/Logo.png" style="cursor:pointer" onclick="mainPage()" width="100" height="50%"  />
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse">
      
    	</div>
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
		<div class="container">
		 
		 	<div class="flex-container" style="background-color:#ffffff"> 
		 	
		 		<div width="900"  >
		 		
		 			<div align="right">
		 			
					<form class="form-inline my-2 my-lg-0 float-sm-right"" name = "type" action="/board/listAll" method="post" padding-left="300px">
					
						<select class="form-control " name = "type"  >
							<option value = "title">제목</option>
							<option value = "id">아이디</option>
						</select>
						
						<input class="form-control mr-sm-2" type = "search" name = "keyWord" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-dark" type = "submit" value =" onclick="searchCheck(form)">검색</button>
						
					</form>
					</div>	
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
						<td><p>${page.listCnt-(page.startIndex + status.count)+1 }</p></td>
					 	<td><a href="/board/detail?seq=${boardVo.seq }&id=${boardVo.writer}">${boardVo.title }</a></td>
						<td>${boardVo.writer }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.date }"/></td>
						<td><span>${boardVo.count }</span></td>
					</tr>
			
					</c:forEach>	
				</table>
			</div>
				
		 </div>
		 
			
			<div align="right">
				<button class="btn btn-light" type = "button" onclick="location.href='/board/create' " >글쓰기</button>
			</div>
			<div align="center">
		        <c:if test="${page.curRange ne 1 }">
		            <a href="#" onClick="fn_paging(1)">[</a> 
		        </c:if>
		        <c:if test="${page.curPage ne 1}">
		            <a href="#" onClick="fn_paging('${page.prevPage }')">[</a> 
		        </c:if> 
		        <c:forEach var="pageNum" begin="${page.startPage }" end="${page.endPage }">
		            <c:choose>
		                <c:when test="${pageNum eq  page.curPage}">
		                    <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
		                </c:when>
		                <c:otherwise>
		                    <a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		        <c:if test="${page.curPage ne page.pageCnt && page.pageCnt > 0}">
		            <a href="#" onClick="fn_paging('${page.nextPage }')">다음</a> 
		        </c:if>
		        <c:if test="${page.curRange ne page.rangeCnt && page.rangeCnt > 0}">
		            <a href="#" onClick="fn_paging('${page.pageCnt }')">[</a> 
		        </c:if>
		    </div>
		    <%--
		    <div>
		        : ${page.listCnt } /    : ${page.pageCnt } / : ${page.curPage } / : ${page.curRange } / : ${page.rangeCnt }
		    </div>
		     --%>
		</div>
	</div>
	
</body>
</html>