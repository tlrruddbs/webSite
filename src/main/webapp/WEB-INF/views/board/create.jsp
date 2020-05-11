<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<script> 
	function back(){
		history.back();
	}
	function mainPage(){
		location.href="/svc/member/main";
	}
	
</script>
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
		    <img src="/resources/images/Logo.png" style="cursor:pointer"  width="100" height="50%" onclick="mainPage();"/>
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
			<div class="container" role="main">
				<div class="column_left">
				</div>
				
				<div class="column_center" align="center">
					
					<h1 class="text-dark"></h1>
	
					<form action="/board/create" method="POST">
				        <div class="createForm">
				            <label class="text-dark"></label>
				          	  제목<input type="text" name="title" class="createForm" placeholder = "" cols="30">
				        </div>
				        <div class="createForm">
				            <label class="text-dark"></label>
				            내용<textarea rows="4" cols="15" name="content" class="createForm" placeholder = ""></textarea>
				        </div>
				        <div class="createForm">
				            <label class="text-dark">작성자 : ${member.userId }</label>
				            
				            <input type="hidden" name="writer" class="createForm" placeholder = "" value=${member.userId }>
				        </div>
				        <!--  
				        <div>
				        	<a href="#this" id="add" class="btn btn-outline-light">
				        </div>
				         -->
				        <div class="Formfooter">
				                <button type="submit" class="btn btn-outline-dark">작성</button>
				        </div>            
				        
					</form>
					<button type = "button" class="btn btn-outline-dark" onclick = "back();">뒤로가기</button>
					
					
	  			</div>
	  			
	  		</div>
		</div>
		

	
</body>
</html>