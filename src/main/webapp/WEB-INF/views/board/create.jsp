<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 등록하기</h1>
	
	<form action="/board/create" method="POST">
        <div class="createForm">
            <label >제목</label>
            <input type="text" name="title" class="createForm" placeholder = "게시판 제목">
        </div>
        <div class="createForm">
            <label >내용</label>
            <textarea rows="4" cols="15" name="content" class="createForm" placeholder = "게시판 내용"></textarea>
        </div>
        <div class="createForm">
            <label >작성자</label>
            ${member.userId }
            <input type="hidden" name="writer" class="createForm" placeholder = "작성자" value=${member.userId }>
        </div>
        
        <div class="Formfooter">
                <button type="submit" class="btn_button">작성하기</button>
        </div>            
        
	</form>
</body>
</html>