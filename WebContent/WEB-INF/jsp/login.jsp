<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
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