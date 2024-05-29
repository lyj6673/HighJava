<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>forward, redirect연습</h2><hr>

<form action="/webTest/forwardTest01.do" method="post">
	forward연습 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>

<br><hr><br>
<form action="" method="post">
	forward연습 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>
</body>
</html>