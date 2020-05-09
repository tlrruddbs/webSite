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


	function add(){
		var memberSelect = $("select[name=memberSelectBox]").val();
		var stationSelect = $("select[name=stationSelectBox]").val();
	//	alert(memberSelect+", "+stationSelect);
		var jobj = new Object();
		jobj.memberSelect = memberSelect;
		jobj.stationSelect = stationSelect;
		
		$.ajax({
    		url:"/svc/admin/memberList/authority/add",
    		contentType:"application/json",
            dataType:"json",
            type: "POST",                                
            data: JSON.stringify(jobj),	
    		success:function(data){
    			if(data.idChk>0){
    				alert("아이디 중복입니다.");
    			} else {
    				if(data.authorityChk>0){
    					alert("");
    				} else {
    					alert("");
    				}
    			}
    			
    		},
    		error:function(){
    			alert("err");
    		}
    	});
	}
	
	
	function deleteId(){
		var memberSelect = $("select[name=memberSelectBox]").val();
		var stationSelect = $("select[name=stationSelectBox]").val();
	//	alert(memberSelect+", "+stationSelect);
		var jobj = new Object();
		jobj.memberSelect = memberSelect;
		jobj.stationSelect = stationSelect;
		
		$.ajax({
    		url:"/svc/admin/memberList/authority/delete",
    		contentType:"application/json",
            dataType:"json",
            type: "POST",                                
            data: JSON.stringify(jobj),	
    		success:function(data){
    			if(data.idChk==0){
    				alert(");
    			} else if(data.idChk>0){
    				if(data.deleteChk==0){
        				alert(");
        			} else if(data.deleteChk>0){
        				alert(");
        			}
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
		
		<c:if test="${!empty stationList}" >
				
				   <select name="stationSelectBox" id="stationSelectBox" style="width:80px;" class="select_02">
				
				      <c:forEach var="testList" items="${stationList}" varStatus="i">
				
				         <option value="${testList.SEQ}">${testList.NAME}</option>
				
				      </c:forEach>
				
				   </select>
				
				</c:if>
				
				<c:if test="${!empty memberAuthorityList}" >
				
				   <select name="memberSelectBox" id="memberSelectBox" style="width:80px;" class="select_02">
				
				      <c:forEach var="testList" items="${memberAuthorityList}" varStatus="i">
				
				         <option value="${testList.USERID}">${testList.USERID}</option>
				
				      </c:forEach>
				
				   </select>
				
				</c:if>
		
		<div style="float:right;">
			<button class="btn btn-secondary btn-sm" type="button" onclick = "add()" ></button>
		</div>
		<div style="float:right;">
			<button class="btn btn-secondary btn-sm" type="button" onclick = "deleteId()" ></button>
		</div>
	</div>
	
	
	
</body>
</html>