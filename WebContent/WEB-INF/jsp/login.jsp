<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/mdb.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/icon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath }/login" method="post">
		<div>
			Phone:<input type="text" name="phone">
		</div>
		<div>
			Password:<input type="text" name="password">
		</div>
		<input type="submit" value="submit">
	</form>
</body>
</html>