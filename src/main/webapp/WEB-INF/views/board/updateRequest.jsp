<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
	function mainPage(){
		location.href="/svc/member/main";
	}
</script>
<title>글 수정</title>
</head>
<style>
	h2 { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display:block;
		width: 30%;
		margin: auto;
	}
	.inlineBox{
		float:left;
	}
</style>
<body>
	<style type = "text/css">
				.jumbotron{
					background-image:url('/resources/images/boardBlack.png');
					background-size:cover;
					text-shadow: black 0.2em 0.2em 0.2em;
					color:black;
					
				}
	</style>

	<nav class="navbar navbar-expand-lg navbar-dark"> 
	<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
	    <img src="/resources/images/logo.png" style="cursor:pointer" onclick="mainPage()" width="100" height="50"  />
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">
	    	</div>
	 	</div>
	</nav>
	
	<div class="jumbotron" >
		<div class="container">
			<h2>게시판</h2>
<br><br><br>
<div id="outter">
	<table  class = "table table-board text-light" border="2px" width="80%" align="center">
	<form action="/board/update" method="POST">
		<tr class="inlineBox">
			<h4 class="text-light inlineBox" style="width:30%" >제목 :</h5> <input class="form-control" style="width: 70%" type="text" id="title" name="title" value="${board.title }"/></h4> 
			
		
		</tr>
		
		<tr>
			<td>
				작성자: ${board.writer }
				<span style="float: right;"><fmt:formatDate value="${board.date }" pattern="yyyy.MM.dd"/></span>
			</td>
		</tr>
		<tr>
			<td>
			<input type ="text" id="content" value="${board.content }" name="content" style="width:300px; height:250px";/>
			</td>
		<!-- 	<td><textarea rows="20" cols="100" title="내용" id="content" name="content"></textarea></td> -->
		<!-- 	<td><input type = "text" id=div style="height: 300px; margin: 10px; display: inline-block">${board.content }</div></td> -->
		</tr>
		<input type="hidden" name="seq" value=${board.seq }>
	</table>
	<input class="btn btn-light" type="submit" value="수정하기" style="float: right;">
	<input class="btn btn-light" type="button" value="글 목록" style="float: right;" onclick="location.href='listAll';"> 
	</form>
</div>
			 
		</div>
		</div>
	</div>

</body>
</html>