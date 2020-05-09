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
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script> 
	function modify(userId){
		var jobj = new Object();
		jobj.userId = userId;
		jobj.memberStatus = $("#type").val();
		
		$.ajax({
    		url:"/svc/admin/memberList/singleMemberView/modifyInfo",
    		contentType:"application/json",
            dataType:"json",
            type: "POST",                                
            data: JSON.stringify(jobj),	
    		success:function(data){
    			alert("수정되었습니다.");
    			location.reload(true);
    		},
    		error:function(){
    			alert("err");
    		}
    	});
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
	    <img src="/resources/images/logo.png" style="cursor:pointer" width="100" height="50" onclick="reload();"  />
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
		</button>
		
		<div  class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    
		    
	 	</div>
	</nav>
	
	<div class="container">
		<table class = "table table-board" border="2px" width="80%" align="center">
			<tr>
				<th style = "width:20%">아이디</th>
				<td>${memberVo.userId }</td>
			</tr>
			<tr>
				<th style = "width:20%">이메일</th>
				<td>${memberVo.userEmail }</td>
			</tr>
			<tr>
				<th style = "width:20%">이름</th>
				<td>${memberVo.userName }</td>
			</tr>
			<tr>
				<th style = "width:20%">가입날짜</th>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${memberVo.regDate }"/></td>
			</tr>
			<tr>
				<th style = "width:20%">회원구분</th>
				<c:choose>
					<c:when test = "${memberVo.memberCode eq 'CMMMCD002'}">
						<td>
							회원
						</td>
					</c:when>
					<c:otherwise>
						<td>
							관리자
						</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th style = "width:20%">회원 상태</th>
				<c:choose>
					<c:when test = "${memberVo.memberStatus eq 'CMMMST001'}">
						<td>
						정상
							<select id = "type">
								<option value = "Normal">정상</option>
								<option value = "Stop">일시정지</option>
								<option value = "Ban">영구정지</option>
								<option value = "Leave">탈퇴</option>
							</select>
						</td>
					</c:when>
					<c:when test = "${memberVo.memberStatus eq 'CMMMST002'}">일시정지
					
						<td>
						일시정지 
							<select id = "type">
								<option value = "Normal">정상</option>
								<option value = "Stop">일시정지</option>
								<option value = "Ban">영구정지</option>
								<option value = "Leave">탈퇴</option>
							</select>
						</td>
					</c:when>
					<c:when test = "${memberVo.memberStatus eq 'CMMMST003'}">
						<td>
						영구정지
							<select id = "type">
								<option value = "Normal">정상</option>
								<option value = "Stop">일시정지</option>
								<option value = "Ban">영구정지</option>
								<option value = "Leave">탈퇴</option>
							</select>
						</td>
					</c:when>
					<c:otherwise>
						<td>
						탈퇴
							<select id = "type">
								<option value = "Normal">정상</option>
								<option value = "Stop">일시정지</option>
								<option value = "Ban">영구정지</option>
								<option value = "Leave">탈퇴</option>
							</select>
						</td>
					</c:otherwise>	
				</c:choose>
			</tr>	
		</table>
		<div style="float:right;">
			<button class="btn btn-secondary btn-sm" type="button" onclick = "modify('${memberVo.userId}')" >수정하기</button>
		</div>
	</div>
	
	
	
</body>
</html>