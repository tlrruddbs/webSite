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
<title>Insert title here</title>
	
<script>
	function back(){
		var sessionId = <%=session.getAttribute("user") %>
		alert(sessionid);
		if(null == session.getAttribute("user")){
			alert("1234");
			location.href="/login";
			
		}else{
			alert("1235");
			location.href="/svc/member/main";
			
		}
		
	}

	function searchCheck(frm){
		if(frm.keyWord.value == ""){
			alert("검색 단어를 입력하세요.");
			frm.keyWord.focus();
			return;
		}
		frm.submit();
	}
	
	var msg = "${msg}";
	if(msg == "listEmpty"){
		alert("해당하는 검색 조건이 없습니다.");
		location.href="/board/listAll";

	}
	
	function fn_paging(curPage) {
		location.href = "/board/listAll?curPage=" + curPage;
	}
</script>
	
</head>
<body>
	<style type = "text/css">
			.jumbotron{
				background-image:url('/resources/images/mainOpaque.png');
				background-size:cover;
				text-shadow: black 0.2em 0.2em 0.2em;
				color:black;
				
			}
		</style>

		<nav class="navbar navbar-expand-lg navbar-dark"> 
		<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
		    <img src="/resources/images/logo.png" style="cursor:pointer" onclick="back()" width="100" height="50"  />
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">	
		    <%--  	<a class="nav-item nav-link active text-light" href="#" >Home <span class="sr-only">(current)</span></a> --%>
		      	<a class="nav-item nav-link text-light" href="/board/listAll" >자유게시판</a>
		      	<a class="nav-item nav-link text-light" href="/login" >로그인</a>
		      	<a class="nav-item nav-link text-light" href="#">회원가입</a>
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

	
	
	<div class="jumbotron" >
		<div class="container">
		
			<div align="right">
			<button class="btn btn-light btn-sm" type = "button" onclick="location.href='/board/myBoardList' " height="80%" >내가 쓴 글</button>
			<button class="btn btn-light btn-sm" type = "button" onclick="location.href='/svc/logout' ">로그아웃</button>
			<button class="btn btn-light btn-sm" type = "button" onclick = "back();">메인화면</button>
			
			<form class="form-inline my-2 my-lg-0" name = "type" action="/board/listAll" method="post">
				<select class="form-control" name = "type">
					<option value = "title">제목</option>
					<option value = "id">아이디</option>
				</select>
				
				<input class="form-control mr-sm-2" type = "search" name = "keyWord" placeholder="Search" aria-label="Search">
			<%--	<input type = "button" value ="검색" onclick="searchCheck(form)"/> --%>
				<button class="btn btn-outline-light" type = "submit" value ="검색" onclick="searchCheck(form)">검색</button>
			</form>
			
			</div>
			
			
			<table class = "table table-board text-light" border="1px" width="80%" align="center">
				<tr>
					<th style = "width:10%">글 번호</th>
					<th style = "width:30%">제목</th>
					<th style = "width:20%">작성자</th>
					<th style = "width:20%">날짜</th>
					<th style = "width:20%">조회수</th>
				</tr>
				
			<%--	<c:forEach items = "${boardList}" var = "boardVo"> --%> 
				<c:forEach items = "${boardList}" var = "boardVo" varStatus="status">
				<tr>
				<%--	<td>${status.count }</td> --%>
					<td>${page.listCnt-(page.startIndex + status.count)+1 }</td>
					<td>${boardVo.title }</td>
					<td>${boardVo.writer }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.date }"/></td>
					<td><span>${boardVo.count }</span></td>
				</tr>
		
				</c:forEach>	
			</table>
			<div align="right">
				<button class="btn btn-light" type = "button" onclick="location.href='/board/create' " >글쓰기</button>
			</div>
			<div align="center">
		        <c:if test="${page.curRange ne 1 }">
		            <a href="#" onClick="fn_paging(1)">[처음]</a> 
		        </c:if>
		        <c:if test="${page.curPage ne 1}">
		            <a href="#" onClick="fn_paging('${page.prevPage }')">[이전]</a> 
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
		            <a href="#" onClick="fn_paging('${page.nextPage }')">[다음]</a> 
		        </c:if>
		        <c:if test="${page.curRange ne page.rangeCnt && page.rangeCnt > 0}">
		            <a href="#" onClick="fn_paging('${page.pageCnt }')">[끝]</a> 
		        </c:if>
		    </div>
		    <%--
		    <div>
		        총 게시글 수 : ${page.listCnt } /    총 페이지 수 : ${page.pageCnt } / 현재 페이지 : ${page.curPage } / 현재 블럭 : ${page.curRange } / 총 블럭 수 : ${page.rangeCnt }
		    </div>
		     --%>
		</div>
	</div>
	
</body>
</html>