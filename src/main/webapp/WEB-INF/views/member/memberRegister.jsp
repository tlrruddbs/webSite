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
<title>회원가입</title>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>
	function loginPage(){
		location.href="/login";
	}

</script>
<body>
	<style type = "text/css">
		.jumbotron{
			background-image:url('/resources/images/main.png');
			background-size:cover;
			text-shadow: black 0.2em 0.2em 0.2em;
			color:black;
			
		}
	</style>
	
	<nav class="navbar navbar-expand-lg navbar-dark"> 
		<%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
		    <img src="/resources/images/logo.png" style="cursor:pointer"  width="100" height="50" onclick="loginPage();"/>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">	
		  <%--    	<a class="nav-item nav-link active text-light" href="#" >Home <span class="sr-only">(current)</span></a> --%>
		      	<a class="nav-item nav-link text-light" href="/board/listAll" >자유게시판</a>
		      	<a class="nav-item nav-link text-light" href="/login" >로그인</a>
		      	<a class="nav-item nav-link text-light" href="/member/memberRegister">회원가입</a>
		      <%--
			     <div class="dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  text-align="right">
			          	로그인
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				        <a class="dropdown-item" href="#">로그인</a>
				        <a class="dropdown-item" href="#">회원가입</a>
		    	    </div>
	      		</div>
	      		 --%>
	    	</div>
	 	</div>
		</nav>
		
		<div class="jumbotron" >
			<div class="container" role="main">
				<div class="panel-heading">
                     <div class="panel-title"></div>
                 </div>
                 <div class="panel-body">
                     <form action="/member/register" id="login-form" method="post" onsubmit="return check()">
                    	 <div>
                             <input type="text" name="userId" placeholder="id" id="userId" autofocus>
                             <input type="button" name ="idChk" onclick="checkId();" value = "중복 체크" class="btn btn-outline-light">
                         </div>
                         <div>
                             <input type="password" id = "userPw" name="userPw" placeholder="Password" oninput="checkPwd()">
                         </div>
                         <div>
                             <input type="password" name="userPwConfirm" placeholder="Confirm Password" id="userRePw" oninput="checkPwd()">
                         </div>
                         <div>
                             <input type="email" name="userEmail" id="userEmail" placeholder="Email" autofocus>
                         </div>
                         <div>
                             <input type="text" name="userName" id="userName" placeholder="Your name" oninput="checkNick()" autofocus>
                         </div>
                         <div>
                             <button type="submit" class="btn btn-outline-light">회원가입</button>
                             
                             <!-- signupbtn" disabled="disabled" -->
                         </div>
                         
                     </form>
                 </div>
				<div class="column_left">
				
				</div>
				
					
					
					
	  			</div>
				
				<div class="column_right">
					
					
					
	  			</div>
	  			
	  		</div>
		</div>
	<%--
     <div class="container">
         <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
             <div class="panel panel-success">
                 <div class="panel-heading">
                     <div class="panel-title">환영합니다!</div>
                 </div>
                 <div class="panel-body">
                     <form action="/member/register" id="login-form" method="post" onsubmit="return check()">
                    	 <div>
                             <input type="text" name="userId" placeholder="id" id="userId" autofocus>
                             <input type="button" name ="idChk" onclick="checkId();" value = "중복 체크">
                         </div>
                         <div>
                             <input type="password" id = "userPw" name="userPw" placeholder="Password" oninput="checkPwd()">
                         </div>
                         <div>
                             <input type="password" name="userPwConfirm" placeholder="Confirm Password" id="userRePw" oninput="checkPwd()">
                         </div>
                         <div>
                             <input type="email" name="userEmail" id="userEmail" placeholder="Email" autofocus>
                         </div>
                         <div>
                             <input type="text" name="userName" id="userName" placeholder="Your name" oninput="checkNick()" autofocus>
                         </div>
                         <div>
                             <button type="submit">회원가입</button>
                             
                             <!-- signupbtn" disabled="disabled" -->
                         </div>
                         
                     </form>
                 </div>
             </div>
             <%--
             <input type = "button" name="btn" id="btn" onclick="btnClick();" value="ajax test">
             <input type = "button" name="btn2" id="btn2" onclick="btnClick2();" value="ajax test2">  --%>
         </div>
     </div>
      --%>
     <%--
     <button id = "btn1">simpleAJAX</button> --%>
     <div id="result"></div>
     
     <script>
     var idCheck = 0;
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
    		 alert("아이디 중복확인을 눌러주세요")
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
     
     function btnClick2(){
     	var userId = $("#userId").val()
     	alert(userId);
     	var form_data = {};
     	form_data["name"] = userId;
     	form_data["age"] = "28";
     	
     	$.ajax({
     		url:"/login/ajaxTest2",
     		type:"POST",
     		data:JSON.stringify(form_data),
     		contentType:"application/json",
     		dataType:"json",
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
							alert("중복된 아이디입니다.")
						} else {
							alert("사용 가능한 아이디입니다.")
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
			<!--
			//재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
			function checkPwd() {
				var inputed = $('.pass').val();
				var reinputed = $('#repwd').val();
				console.log(inputed);
				console.log(reinputed);
				if (reinputed == ""
						&& (inputed != reinputed || inputed == reinputed)) {
					$(".signupbtn").prop("disabled", true);
					$(".signupbtn").css("background-color",
							"#aaaaaa");
					$("#repwd").css("background-color", "#FFCECE");
				} else if (inputed == reinputed) {
					$("#repwd").css("background-color", "#B0F6AC");
					pwdCheck = 1;
					if (idCheck == 1 && pwdCheck == 1) {
						$(".signupbtn").prop("disabled", false);
						$(".signupbtn").css("background-color",
								"#4CAF50");
					}
				} else if (inputed != reinputed) {
					pwdCheck = 0;
					$(".signupbtn").prop("disabled", true);
					$(".signupbtn").css("background-color",
							"#aaaaaa");
					$("#repwd").css("background-color", "#FFCECE");

				}
			}
			//닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
			function checkNick() {
				var name = $("#name").val();
				console.log(name);
				$.ajax({
					data : {
						name : name
					},
					url : "checkname.do",
					success : function(data) {
						if (name == "" && data == '0') {
							$(".signupbtn").prop("disabled", true);
							$(".signupbtn").css("background-color",
									"#aaaaaa");
							$("#name").css("background-color",
									"#FFCECE");
							nickCheck = 0;
						} else if (data == '0') {
							$("#name").css("background-color",
									"#B0F6AC");
							nickCheck = 1;
							if (idCheck == 1 && pwdCheck == 1) {
								$(".signupbtn").prop("disabled",
										false);
								$(".signupbtn").css(
										"background-color",
										"#4CAF50");
							}
						} else if (data == '1') {
							$(".signupbtn").prop("disabled", true);
							$(".signupbtn").css("background-color",
									"#aaaaaa");
							$("#name").css("background-color",
									"#FFCECE");
							nickCheck = 0;
						}
					}
				});
			}
			-->
		</script>
 </body>

</html>