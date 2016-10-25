<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="profiles" ng-cloak>
<head>
<title>Update Profile Info</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/profile/update" method="post" enctype="multipart/form-data">
					<h2 class="ui header">Update Profile Info</h2>					
					<input type="hidden" name="id" value="${form.id }">
					<div class="fourteen wide field">
						<label>Name</label> <input type="text" name="name" placeholder="Name" value="${form.name }">
					</div>
					<div class="fourteen wide field">
						<label>NickName</label> <input type="text" name="nickname" placeholder="NickName" value="${form.nickName }">
					</div>
					<div class="fourteen wide field">
						<label>Avatar</label> <input type="file" name="avatar" accept="image/*" placeholder="Avatar">
					</div>
					<div class="fourteen wide field">
						<label>Phone</label> <input type="text" name="phone" placeholder="Phone" value="${form.phone }">
					</div>
					<div class="fourteen wide field">
						<label>Email</label> <input type="text" name="email" placeholder="Email" value="${form.email }">
					</div>
					<div class="fourteen wide field">
						<label>Address</label> <input type="text" name="address" placeholder="Address" value="${form.address }">
					</div>
					<div class="fourteen wide field">
						<label>Profession</label> <input type="text" name="profession" placeholder="Profession" value="${form.profession }">
					</div>
					<div class="fourteen wide field">
						<label>Intro</label> 
						<textarea rows="2" name="intro" placeholder="Intro">${form.intro }</textarea>
					</div>
					<input class="ui large teal submit button" type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>