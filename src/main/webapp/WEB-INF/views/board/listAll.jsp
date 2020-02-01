<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="org.hello.controller.utils.Pagination"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<script>
	function back(){
		location.href="/svc/member/main";
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
	<button type = "button" onclick="location.href='/board/create' ">글쓰기</button>
	<button type = "button" onclick="location.href='/board/myBoardList' ">내가 쓴 글</button>
	<button type = "button" onclick="location.href='/svc/logout' ">로그아웃</button>
	<button type = "button" onclick = "back();">메인화면</button>
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
	
	<div>
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
    
    <div>
        총 게시글 수 : ${page.listCnt } /    총 페이지 수 : ${page.pageCnt } / 현재 페이지 : ${page.curPage } / 현재 블럭 : ${page.curRange } / 총 블럭 수 : ${page.rangeCnt }
    </div>

	
</body>
</html>