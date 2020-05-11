<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resources/js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
<title>회원가입</title>

</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>
	function loginPage(){
		location.href="/login";
	} 
	
	
    var nickCheck = 0;
    var pwdCheck = 0;
    
    
    
    function check(){	
   	 var userId = $("#userId").val();
   	 var userPw = $("#userPw").val();
   	 var userRePw = $("#userRePw").val();
   	 var userEmail = $("#userEmail").val();
   	 var userName = $("#userName").val();
   	 
   	 if(userId == ""){
   		 alert("아이디를 정확히 입력해주세요");
   		 return false;
   	 } else if(userPw == ""){
   		 alert("비밀번호를 입력해주세요");
   		 return false;
   	 } else if (userPw != userRePw){
   		 alert("비밀번호를 확인해주세요");
   		 return false;
   	 } else if (userEmail == ""){
   		 alert("이메일을 입력해주세요");
   		 return false;
   	 } else if (userName == ""){
   		 alert("이름을 입력해주세요");
   		 return false;
   	 } else if (idCheck != 1){
   		 alert("아이디 중복확인을 눌러주세요");
   		 return false;
   	 }
    }
    
    function btnClick(){
   	var form = {
   			name:"ks",
   			age:27
   	}
   	$.ajax({
   		url:"/login/ajaxTest2",
   		type:"POST",
   		data:form,
   		success:function(data){
   			alert("success");
   			alert(data.name);
   			alert(data.age);
   		},
   		error:function(){
   			alert("err");
   		}
   	});
    }
    
     //아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정
    
    //아이디 체크하여 가입버튼 비활성화, 중복확인.
    function checkId() {
    	idCheck=0;
        var form_data={}; 
        form_data["userId"] = $("#userId").val();
			var deny_char = /^[a-z|A-Z|0-9|\*]+$/;

				if (!deny_char.test($("#userId").val())) {
					alert("영문자와 숫자만을 입력하세요");
					objtext1.value = "";
					objtext1.focus();
					return false;
				}

				$.ajax({
					data : JSON.stringify(form_data),
					contentType : "application/json",
					dataType : "json",
					type : "POST",
					url : "/member/idChk",
					success : function(data) {
						if (data.idChk > 0) {
							alert("중복된 아이디입니다.");
						} else {
							alert("사용 가능한 아이디입니다.");
							idCheck = 1;
						}
					},
					error : function(request, status, error) {
						//에러코드
						//alret(jqXHR + textStatus + errorThrown);
						var msg = "ERROR<br><br>"
						msg += request.status + "<br>"
								+ request.responseText + "<br>"
								+ error;
						console.log(msg);
					}
				});
			}

</script>
<body>
	<style type="text/css">
.flex-container {
	width: 100%;
	height: 80vh;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-align: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	justify-content: center;
}

.logoBox {
	width: 26%;
	height: 60vh;
	background-image: url('/resources/images/Sign-in WG.png');
	text-align: center;
	padding: 2em;
}

.settingForm {
	width: 26%;
	height: 50vh;
	text-align: center;
	padding: 2em;
}

.jumbotron {
	background-image: url('/resources/images/background.jpg');
	background-size: cover;
	color: black;
}
</style>

	<nav class="navbar navbar-expand-lg navbar-dark"> <%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	</nav>
	<div class="jumbotron">
		<div class="container" role="main">
			<div class="flex-container">
				<div class="logoBox">
					<div class="settingForm" style="padding-top: 120px;">
						<form action="/member/register" id="login-form" method="post"
							onsubmit="return check()">
							<div>
								<input type="text" name="userId" placeholder="id" id="userId"
									autofocus> <a class="nav-item nav-link text-light"
									href="#" onclick="checkId();">Idcheck</a>
							</div>
							<div>
								<input type="password" id="userPw" name="userPw"
									placeholder="Password" oninput="checkPwd()">
							</div>
							<div style="padding-top: 15px;">
								<input type="password" name="userPwConfirm"
									placeholder="Confirm Password" id="userRePw"
									oninput="checkPwd()">
							</div>
							<div style="padding-top: 15px;">
								<input type="email" name="userEmail" id="userEmail"
									placeholder="Email" autofocus>
							</div>
							<div style="padding-top: 15px;">
								<input type="text" name="userName" id="userName"
									placeholder="Your name" oninput="checkNick()" autofocus>
							</div style="padding-top: 15px;">
							
							<div>
                             <button type="submit" class="btn btn-outline-light">가입</button>
                             
	                             <!-- signupbtn" disabled="disabled" -->
	                         </div>
<!-- 
							<div style="align: center; padding-top: 15px;">
								<a href="#"
									onclick="document.getElementById('login-form').submit();"><img
									src="/resources/images/log-in botton_signin.png"
									style="width: 170px; height: 35px;" /></a>
							</div>
 -->

						</form>

					</div>
				</div>

			</div>
		</div>
	</div>

	</div>

	</div>
	</div>
	<div id="result"></div>

	<script>
     
		
		</script>
</body>

</html>