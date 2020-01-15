<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
</head>
<style>
	h2 { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display: block;
		width: 30%;
		margin: auto;
	}
</style>
<body>

<h2>게시판</h2>
<br><br><br>
<div id="outter">
	<table border="1">
	<form action="/board/update" method="POST">
		<tr>
			제목 : 
			<input type="text" id="title" name="title" value="${board.title }"/>
		
		</tr>
		<tr>
			<td>
				작성자: ${board.writer }
				<span style="float: right;"><fmt:formatDate value="${board.date }" pattern="yyyy.MM.dd"/></span>
			</td>
		</tr>
		<tr>
			<td>
			<input type ="text" id="content" value="${board.content }" name="content" style="width:200px; height:200px";/>
			</td>
		<!-- 	<td><textarea rows="20" cols="100" title="내용" id="content" name="content"></textarea></td> -->
		<!-- 	<td><input type = "text" id=div style="height: 300px; margin: 10px; display: inline-block">${board.content }</div></td> -->
		</tr>
		<input type="hidden" name="seq" value=${board.seq }>
	</table>
	<input type="submit" value="수정하기" style="float: right;">
	<input type="button" value="글 목록" style="float: right;" onclick="location.href='listAll';"> 
	</form>
</div>
</body>
</html>