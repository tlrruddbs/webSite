<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<script>
	function back(){
		history.back();
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
</script>
	
</head>
<body>
	<button type = "button" onclick="location.href='/board/create' ">글쓰기</button>
	<button type = "button" onclick="location.href='/board/myBoardList' ">내가 쓴 글</button>
	<button type = "button" onclick="location.href='/svc/logout' ">로그아웃</button>
	<button type = "button" onclick = "back();">뒤로가기</button>
	<form name = "type" action="/board/listAll" method="post">
		<select name = "type">
			<option value = "title">제목</option>
			<option value = "id">아이디</option>
		</select>
		<input type = "text" name = "keyWord"/>
		<input type = "button" value ="검색" onclick="searchCheck(form)"/>
	</form>
	
	<table class = "table table-board" border="1px" width="80%" align="center">
		<tr>
			<th style = "width:10%">글 번호</th>
			<th style = "width:30%">제목</th>
			<th style = "width:20%">작성자</th>
			<th style = "width:20%">날짜</th>
			<th style = "width:20%">조회수</th>
		</tr>
		<c:forEach items = "${boardList}" var = "boardVo">
			<tr>
				<td>${boardVo.seq }</td>
				<td><a href="/board/detail?seq=${boardVo.seq }&id=${boardVo.writer}">${boardVo.title }</a></td>
				<td>${boardVo.writer }</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVo.date }"/></td>
				<td><span>${boardVo.count }</span></td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>