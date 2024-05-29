<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	HTML 주석...
 -->
 <%--
 	JSP 주석...
  --%>
  
  <%
  	//이 영역은 JSP문서에서 Java명령을 사용할 수 있는 영역으로 '스크릿트립'이라고 한다.
  	String name = "홍길동";
  %>
 
<%--
  <%=변수나 수식 %>		==> JSP에서 변수나 수식의 결과를 출력할 때 사용
  					==> 이것을 'Expression(표현식)'이라고 함
 --%>  
 <!-- 
 	<form>태그의 속성
 	1) action => <form>태그에서 구성한 데이터를 받아서 처리할 '문서명' 또는 '서블릿 URL'
 	2) method => 전송방식(GET 또는 POST), 기본값은 GET
 	3) target => 응답이 나타날 프레임을 지정한다.
 	4) enctype => 서버로 파일을 전송할 때는 이 속성을 'multipart/form-data'로 지정해야 한다.
  -->
 
 <h2><%=name %>Request연습 <%=3+4 %></h2>
 <form action="/webTest/requestTest01.do" method="get">
 <table border="1">
 <tr>
 	<td>이 름</td>
 	<td><input type="text" size="10" name="username"></td>
 </tr>
 <tr>
 	<td>직 업</td>
 	<td><select name="job">
 		<option value="학생">= 학생 =</option>
 		<option value="회시원">= 회사원 =</option>
 		<option value="전문직">= 전문직 =</option>
 		<option value="무직">= 무직 =</option>
 	</select></td>
 </tr>
 
  <tr>
 	<td>취 미</td>
 	<td>
 		<input type="checkbox" name="hobby" value="여행">여행
 		<input type="checkbox" name="hobby" value="독서">독서
 		<input type="checkbox" name="hobby" value="바둑">바둑
 		<input type="checkbox" name="hobby" value="장기">장기
 	</td>
 </tr>
  <tr>
 	<td colspan="2" style="text-align:center;">
 		<input type="submit" value="전송">
 		<input type="reset" value="초기화">
 	</td>
 </tr>
 </table>
 
 </form>
</body>
</html>