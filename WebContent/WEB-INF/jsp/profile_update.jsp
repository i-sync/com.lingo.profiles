<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="profiles" ng-cloak>
<head>
<title>Update Profile Info</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/jsp/manage-sidenav.jsp"%>
	<main>
	<div class="main-wrapper">
		<%@include file="/WEB-INF/jsp/header.jsp"%>
		<h1>Update Profile Info</h1>
		<form action="${pageContext.request.contextPath }/profile/update"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${form.id }">
			<div>
				Name: <input type="text" name="name" value="${form.name }">
			</div>
			<div>
				NickName: <input type="text" name="nickName"
					value="${form.nickName }" />
			</div>
			<div>
				Avatar: <input type="file" name="avatar">
			</div>
			<div>
				Phone: <input type="text" name="phone" value="${form.phone }" />
			</div>
			<div>
				Email: <input type="text" name="email" value="${form.email }" />
			</div>
			<div>
				Address: <input type="text" name="address" value="${form.address }" />
			</div>
			<div>
				Intro: <input type="text" name="intro" value="${form.intro }">
			</div>
			<button type="submit" class="md-raised md-primary">Submit</button>
		</form>
	</div>
	</main>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>