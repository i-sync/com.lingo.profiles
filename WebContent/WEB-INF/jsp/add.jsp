<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Profile Info</h1>
	<form action="${pageContext.request.contextPath }/profile/add" method="post" enctype="multipart/form-data">
		<div>
			Name:
			<input type="text" name="name" />
		</div>
		<div>
			Avatar:
			<input type="file" name="avatar"/>
		</div>
		<div>
			Phone:
			<input type="text" name="phone" />
		</div>
		<div>
			Email:
			<input type="text" name="email"/>
		</div>
		<div>
			Address:
			<input type="text" name="address" />
		</div>
		<div>
			Intro:
			<input type="text" name="intro"/>
		</div>
		<button type="submit">Submit</button>
	</form>
</body>
</html>