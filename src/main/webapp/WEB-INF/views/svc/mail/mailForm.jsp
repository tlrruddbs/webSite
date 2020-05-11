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
<script> 
	function reload(){
		location.href = "/login";
	}

	function check(){
		var job = $('#job').val();
		var title = $('#title').val();
		var name = $('#name').val();
		var content = $('#content').val();
		var phoneNum= $('#phoneNum').val();
		var email = $('#email').val();
		
		if(title == ''){
			alert("제목을 입력해주세요");
			$('#title').focus();
			return false;
		} else if(name==''){
			alert('이름을 입력해주세요');
			$('#name').focus();
			return false;
		} else if(email==''){
			alert("이메일을 입력해주세요");
			$('#email').focus();
			return false;
		} else if(emailCheck(email)==false){
			alert("이메일 형식이 아닙니다.");
			$('#email').focus();
			return false;
		} else if(phoneNum==''){
			alert("전화번호를 입력해주세요");
			$('#phoneNum').focus();
			return false;
		} else if(phoneNumCheck(phoneNum)==false){
			alert("전화번호 양식을 맞춰주세요.");
			$('#phoneNum').focus();
			return false;
		} 
		else if(content==''){
			alert("내용을 입력해주세요");
			$('#content').focus();
			return false;
		}
		
		
		return true;
	}
	//이메일 체크 정규식
	function emailCheck(email){
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		return regExp.test(email); // 형식에 맞는 경우 true 리턴	
	}
	
	//핸드폰 번호 체크 정규식
	function phoneNumCheck(phoneNum) {
		var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	
		return regExp.test(phoneNum); // 형식에 맞는 경우 true 리턴
	}
	
</script>
<title>메일 보내기</title>
</head>
<body>
	<style type = "text/css">
			.jumbotron{
				background-image:url('/resources/images/background.jpg');
				background-size:cover;
				color:black;
				
			}
		</style>

		<nav class="navbar navbar-expand-lg navbar-dark"> 
		<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
		    <img src="/resources/images/Logo.png" width="100" height="50%" style="cursor:pointer" onclick="reload();"/>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse">
      
    	</div>
		<div align="right" class="nav navbar-nav navbar-right" >	
		    <div class="collapse navbar-collapse">
		    	<a class="nav-item nav-link text-dark" href="/svc/member/myPage" >myPage</a>
		      	<a class="nav-item nav-link text-dark" href="/board/listAll" >board</a>
		   		<a class="nav-item nav-link text-dark" href="/svc/fileDownload">Read me</a>
		   		<a class="nav-item nav-link text-dark" href="/svc/mail/mailForm">Recruit </a>
		   		<a class="nav-item nav-link text-dark" href="/svc/member/myPage">My page </a>
	    		<a class="nav-item nav-link text-dark" href="/svc/logout" >Logout</a>
	    	</div>
	 	</div>
	 	</div>
		</nav>
		
		
		<div class="jumbotron"  >
			<div class="container" role="main" style="background-color:white;">
				
				<h4>메일 보내기</h4>
			    <form action="/svc/mail/mailSending" method="post" enctype="multipart/form-data" onsubmit="return check()" >
			    
			    	<select class="form-control" id = 'job' name='job' style="width:500px; ">
			    		<option value ="management">경영지원부</option>
			    		<option value ="solution">솔루션 사업부</option>
			    		<option value ="si">SI/SM 부서</option>
			    	</select>
			    	    
				<%--    <div align="center"><!-- 제목 --> --%>
					<div><!-- 제목 -->
				        <input type="text" id="title" name="title" size="80" placeholder="제목을 입력해주세요" class="form-control" >
				    </div>
				    <div>
				    <input type="file", name="uploadfile" placeholder="파일 선택" /><br/>
				    </div>
				    <div><!-- 이름 -->
				        <input type="text" id="name" name="name" size="20" placeholder="이름" class="form-control" >
				 
				        <input type="text" id="email" name="email" size="20" placeholder="이메일" class="form-control" >
				    
				        <input type="text" id="phoneNum" name="phoneNum" size="20" placeholder="연락처 '-' 붙여서 입력해주세요" class="form-control" >
				    </div> 
				    <p>
				    <div><!-- 내용 --> 
				        <textarea name="content" id="content" cols="80" rows="12" resize:none" placeholder="내용#" class="form-control"></textarea>
				    </div>
				    <p>
			        <div>
			            <input type="submit" value="메일 보내기" class="btn btn-outline-dark">
			        </div>
			    </form>
			
				<div class="column_left">
				</div>
				
				<div class="column_right">
					
	  			</div>
	  			
	  		</div>
		</div>


    
    
</body>
</html> 