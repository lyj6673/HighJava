<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 요청 연습</title>
<script>
window.onload = function(){
	document.getElementById("getBtn").addEventListener("click", function(){
		location.href = "/webTest/servletTest03.do";
	})
}
</script>
</head>
<body>
<h2>Servlet 요청 연습</h2>
<br><hr><br>

<h2>Get방식 요청 1 ==> 링크 방식</h2>
<a href="http://localhost/webTest/servletTest03.do">Get방식 요청1</a><br><hr>

<h2>Get방식 요청2 ==> form태그의 method속성이 생략되거나 'Get'으로 설정한 경우</h2>
<form action="http://localhost/webTest/servletTest03.do">
	<input type="submit" value="Get방식 요청2">
</form>
<br><hr>

<h2>Get방식 요청3 ==> JavaScript의 location.href를 이용한 경우</h2>
<form>
	<input type="button" value="Get방식 요청3" id="getBtn">
</form>
<br><hr>

<h2>Post방식 요청 ==> form태그의 method속성을 'Post'로 설정한 경우</h2>
<form action="/webTest/servletTest03.do" method="post">
	<input type="submit" value="Post방식 요청3">
</form>
<br><hr>

</body>
</html>