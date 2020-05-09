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
	
<script> 

	


	function reload(){
		location.href="/svc/admin/adminMain";
	}
	function register(){
		var width = 1076;
		var height = 940;
		
		var popupX = (window.screen.width / 2) - (width / 2);
		// 1/2 

		var popupY= (window.screen.height /2) - (height / 2);
		// 1/2 
		
		window.open('/svc/admin/memberList/register', 'Guardian-CCS User Info', 'resizable=yes, menubar=no, status=no, toolbar=no, location=no, width='+width+', height='+height+', left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	

	function authority(){
		var width = 1076;
		var height = 940;
		
		var popupX = (window.screen.width / 2) - (width / 2);
		// 1/2 

		var popupY= (window.screen.height /2) - (height / 2);
		// 1/2 
		
		window.open('/svc/admin/memberList/authority', 'Guardian-CCS User Info', 'resizable=yes, menubar=no, status=no, toolbar=no, location=no, width='+width+', height='+height+', left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
			
	function passwordModify(){
		var width = 1076;
		var height = 940;
		
		var popupX = (window.screen.width / 2) - (width / 2);
		// 1/2 

		var popupY= (window.screen.height /2) - (height / 2);
		// 1/2 
		
		window.open('/svc/admin/memberList/passwordModify', 'Guardian-CCS User Info', 'resizable=yes, menubar=no, status=no, toolbar=no, location=no, width='+width+', height='+height+', left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
	function details(userId){
		var width = 1076;
		var height = 940;
		
		var popupX = (window.screen.width / 2) - (width / 2);
		// 1/2 

		var popupY= (window.screen.height /2) - (height / 2);
		// 1/2 
		
		window.open('/svc/admin/memberList/singleMemberView?userId='+userId, 'Guardian-CCS User Info', 'resizable=yes, menubar=no, status=no, toolbar=no, location=no, width='+width+', height='+height+', left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
	function infoModify(userId){
		var width = 1076;
		var height = 940;
		
		var popupX = (window.screen.width / 2) - (width / 2);
		// 1/2 

		var popupY= (window.screen.height /2) - (height / 2);
		// 1/2 
		
		window.open('/svc/admin/memberList/infoModify?userId='+userId, 'Guardian-CCS User Info', 'resizable=yes, menubar=no, status=no, toolbar=no, location=no, width='+width+', height='+height+', left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
	function fn_paging(curPage) {
		location.href = "/svc/admin/adminMain?curPage=" + curPage;
	}

</script>
	
</head>
<body>
	<% 
            String msg=request.getParameter("msg");
            
            if(msg!=null && msg.equals("REGISTERED")) 
            {
            	String resultMsg = "";
            	resultMsg += "<script type='text/javascript'>";
            	resultMsg += "alert('회원가입 성공.');";	
            	resultMsg += "window.close();";	
            	resultMsg += "</script>";
            	out.print(resultMsg);
                
            }
        %>    


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
		
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">	
		    <%--  	<a class="nav-item nav-link active text-light" href="#" >Home <span class="sr-only">(current)</span></a> --%>
		    <%--  	<a class="nav-item nav-link text-light" href="/board/adminListAll" >관리자목록</a> --%>
		    	
		      	<a class="nav-item nav-link text-light" onclick="location.href='/svc/admin/memberList' ">${msg }</a>
		      	<a class="nav-item nav-link text-light" onclick="location.href='/svc/admin/logout' ">로그아웃</a>
		      	
		      <%--
			     <div class="dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  text-align="right">
			          	
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				        <a class="dropdown-item" href="#">
				        <a class="dropdown-item" href="#">
		    	    </div>
	      		</div>
	      		 --%>
	    	</div>
	 	</div>
	</nav>
	
	<div class="jumbotron" >
		<div class="container">
			<table class = "table table-board text-light" border="2px" width="80%" align="center">
				<tr>
					>
					<th style = "width:20%">사용자 ID</th>
					<th style = "width:20%">사용자 이름</th>
					<th style = "width:20%">전화번호</th>
					<th style = "width:20%">E-mail</th>
					<th style = "width:20%">권한</th>
				</tr>
				<c:forEach items = "${memberList}" var = "memberVo" varStatus="status">
					<tr>
						
						<td><a href onclick="infoModify('${memberVo.USERID }')">${memberVo.USERID }</a></td>
						<td>${memberVo.USERNM }</td>
						<td>${memberVo.TEL }</td>
						<td>${memberVo.EMAIL }</td>
						
						<c:choose>
							<c:when test = "${memberVo.POWER eq 0}">
								<td>회원</td>
							</c:when>
							<c:when test = "${memberVo.POWER eq 1}">
								<td>관할 관리소</td>
							</c:when>
							<c:otherwise>
								<td>관리자</td>
							</c:otherwise>
						</c:choose>
						
					</tr>
				</c:forEach>	
			</table>
			
			<input type="button" name ="idChk" onclick="register()" value = "사용자 등록" class="btn btn-outline-light">
			<input type="button" name ="idChk" onclick="authority();" value = "관할 관리소 권한등록" class="btn btn-outline-light">
			<input type="button" name ="idChk" onclick="passwordModify();" value = "정보수정" class="btn btn-outline-light">
			<div align="center">
		        <c:if test="${page.curRange ne 1 }">
		            <a href="#" onClick="fn_paging(1)">이전</a> 
		        </c:if>
		        <c:if test="${page.curPage ne 1}">
		            <a href="#" onClick="fn_paging('${page.prevPage }')">이전</a> 
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
		            <a href="#" onClick="fn_paging('${page.pageCnt }')">이전</a> 
		        </c:if>
		    </div>
			
		</div>
	</div>
	

	
</body>
</html>