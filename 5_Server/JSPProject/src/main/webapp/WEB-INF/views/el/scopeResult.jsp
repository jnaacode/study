<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 범위 결과</title>
</head>
<body>

	<% //page scope
		pageContext.setAttribute("message","page");
	
		
	%>

	<pre>
		request 범위 messge : ${message}
		
		session 범위 sessionVaule : ${sessionVaule }
		- 브라우저 종료되기 전까지 요청 받지 않은 페이지에서 확인 가능 
		
		application 범위 appValue : ${appValue}
		- 서버가 꺼지기 전까지 확인 가능 
		
		***  scope 우선 순위 ***
		page > request > session > application
		
		** 원하는 범위(scope)의 값 얻어오기(000Scope)
		
		${ requestScope.message }
		
		${ sessionScope.message }
		
		${ applicationScope.message }
		
	</pre>

</body>
</html>