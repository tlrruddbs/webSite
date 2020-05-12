<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resources/js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"	crossorigin="anonymous"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"	crossorigin="anonymous"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<title></title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script> 
var idCheck;
function checkId() {
	idCheck=0;
    var form_data={};
    form_data["userId"] = $("#userId").val();
    var deny_char = /^[a-z]+[a-z0-9]{5,19}$/g;
		

			if (!deny_char.test($("#userId").val())) {
				alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
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

function check(){
	 var userId = $("#userId").val();
	 var passWD = $("#passWD").val();
	 var userRePw = $("#userRePw").val();
	 var email = $("#email").val();
	 var userNM = $("#userNM").val();
	 var tel = $("#tel").val();
	 var power = $("#authority").val();

	 var regPw = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합

	 
	 if(userId == ""){
		 alert("아이디를 정확히 입력해주세요");
		 return false;
	 } else if(passWD == ""){
		 alert("비밀번호를 입력해주세요");
		 return false;
	 } else if(!regPw.test(passWD)){
		 alert("비밀번호는 8~10자 영문, 숫자여야 합니다 ");
		 return false;
	 } else if (passWD != userRePw){
		 alert("비밀번호를 확인해주세요");
		 return false;
	 } else if (email == ""){
		 alert("이메일을 입력해주세요");
		 return false;
	 } else if (userNM == ""){
		 alert("이름을 입력해주세요");
		 return false;
	 } else if (idCheck == 0){
		 alert("아이디 중복확인을 눌러주세요");
		 return false;
	 }
	 
	 var jobj = new Object();
	jobj.userId = userId;
	jobj.passWD = passWD;
	jobj.email = email;
	jobj.tel = tel;
	jobj.userNM = userNM;
	jobj.power = power;
	
	$.ajax({
		url:"/svc/admin/memberList/memberRegister",
		contentType:"application/json",
	    dataType:"json",
	    type: "POST",                                
	    data: JSON.stringify(jobj),	
		success:function(data){
			
			if(data.memberRegisterChk==1){
				alert("추가 성공");
				window.close();
			} else {
				alert("추가 실패");
				window.close();
			}
			
		},
		error:function(){
			alert("err");
		}
	});
}

</script>

</head>
<body>

	<style type="text/css">
.jumbotron {
	background-image: url('/resources/images/mainOpaque.png');
	background-size: cover;
	text-shadow: black 0.2em 0.2em 0.2em;
	color: black;
}
</style>

	<nav class="navbar navbar-expand-lg navbar-dark"> <%--	<nav class="navbar navbar-expand-lg bg-dark navbar-dark"> --%>
	<img src="/resources/images/logoKS.png" style="cursor: pointer"
		width="100" height="50" onclick="reload();" />
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNavAltMarkup"></div>
	</nav>

	<div class="container">
		<form onsubmit="return check()">
			<div>
				사용자 ID <input type="text" name="userId" placeholder="userId"
					id="userId" >

			</div>
			<div>
				중복 확인 <input type="button" name="idChk" onclick="checkId();"
					value="중복 체크" class="btn btn-outline-dark">
			</div>

			<div>
				사용자 이름<input type="text" name="userNM" id="userNM"
					placeholder="Your name" >
			</div>

			<div>
				패스워드<input type="password" id="passWD" name="passWD"
					placeholder="passWD" >
			</div>
			<div>
				패스워드 확인<input type="password" name="passWDConfirm"
					placeholder="Confirm Password" id="userRePw" >
			</div>

			<div>
				핸드폰 <input type="text" name="tel" id="tel"	placeholder="Your phoneNum" >
			</div>

			<div>
				이메일<input type="email" name="email" id="email"	placeholder="Email" >
			</div>
			<div>

				권한<select class="form-control" id='authority' name='authority' style="width: 300px;">
					<option value="0">일반</option>
					<option value="1">관할 사무소</option>
					<option value="2">시스템 관리자</option>
				</select>
			</div>
			<div>
				<button type="submit" class="btn btn-outline-dark">등록</button>

			</div>

		</form>
	</div>



</body>
</html>