
<!-- person 클래스 import -->
<%@page import="edu.kh.jsp.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인하기</title>
</head>
<body>

	<!-- 
		EL의 특징 
		
		1.get이라는 단어를 사용하지 않음
		왜? 표현언어 == 출력용 언어 == 출력은 얻어와서 밖에 못함
		
		2. EL은 null을 빈칸으로 출력함
			(null과 관련된 것은 모두 빈칸)
	
	
	 -->

	<h3>request에서 Parameter 얻어오기</h3>
	
	<pre>
		EL로 Parameter 얻어와서 출력하는 방법
		\${ param.name속성값 }
	</pre>
	
	1) JSP 표현식 : 
	<%= request.getParameter("inputName") %> / 
	<%= request.getParameter("inputAge") %> /
	<%= request.getParameter("inputAddress") %>
	
	<%= request.getParameter("inputAddress2") %>
	<!-- null 출력 -->
	
	<br><br>
	2) EL(표현언어) :
		${ param.inputName } /
		${ param.inputAge } /
		${ param.inputAddress }
		
		${ param.inputAddress2 }
		 <!-- 빈칸 출력 -->
	 
	 <h3>request에서 속성(Attribute)얻어오기</h3>
	 
	 <pre>
	 	Servlet에서 추가된 속성을 표현(출력)하려는 경우 
	 	request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다!
	 	(import,getAtribute(),다운캐스팅, 변수 저장 모두 생략)	
	 
	 	\${ 속성key }
	 	\${ 속성key.필드명 }
	 	(단,getter가 작성되어 있어야지만 가능)
	 </pre>
	 
	 <%
	 	String menu = (String)request.getAttribute("menu");
	 
		Person person = (Person)request.getAttribute("person");
	 	
	 %>
	 1) JSP 표현식 :<%=menu %> 
	 
	 <!-- Person 클래스의 toString() 출력 -->
	 <br><%=person %>
	 
	 <!-- Person클래스의 getter를 이용해 얻어와서 출력 -->
	 <br><%=person.getName() %>
	 <br><%=person.getAge() %>
	 <br><%=person.getAddress() %>
	 
	 
	 <br><br>
	 
	 2) EL(표현 언어) : ${ menu }
	 
	 <br> ${ person }
	 <br> ${ person.name }
	 <br> ${ person.age }
	 <br> ${ person.address }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
</body>
</html>