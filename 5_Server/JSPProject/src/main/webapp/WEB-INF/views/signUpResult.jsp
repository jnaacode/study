<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    //전달 받은 값 파라미터
    String memberId = request.getParameter("memberId");
    String memberPw = request.getParameter("memberPw");
    String memberName = request.getParameter("memberName");
    String intro = request.getParameter("intro");
    
    /* object 타입이라서 다운캐스팅 진행해야한다. */
    String msg = (String)request.getAttribute("msg");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=memberName %>님 가입 결과</title>
</head>
<body>
	<ul>
		<li>아이디 : <%=memberId %> </li>
		<li>비밀번호 : <%=memberPw %></li>
		<li>이름 : <%=memberName %></li>
		<li>자기소개 : <%=intro %></li>
	</ul>
	
	<h1><%=msg %></h1>
	


</body>
</html>