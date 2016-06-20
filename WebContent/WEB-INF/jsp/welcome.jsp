<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="shortcut icon" href='<c:url value="/img/favicon.ico" />' type="image/x-icon">
<link rel="icon" href='<c:url value="/img/favicon.ico" />' type="image/x-icon">

<style>
	html,body {
		height:100%;
	}
	.main
	{
		color: #fff;
		background-image: url('/img/universe_reflection-wallpaper.jpg');
		background-size: cover;
	}
	.container-fluid
	{
		height:100%;
	}
	h1{
		position:relative; top:30%;
	}
</style>
</head>
<body>
	<div class="container-fluid text-center main">		
		<h1 class="h1-responsive ">Welcome to Lingo Profiles</h1>
	</div>

	<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/js/mdb.min.js"></script>
</body>
</html>