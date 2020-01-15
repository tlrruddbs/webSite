<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	

</head>
<script>
	function back(){
		history.back();
	}
</script>
<body>
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
	
	<button type = "button" onclick = "back();">뒤로가기</button>
</body>
</html>