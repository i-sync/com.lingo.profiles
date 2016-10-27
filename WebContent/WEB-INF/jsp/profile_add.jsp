<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/profile/add" method="post" enctype="multipart/form-data">
					<h2 class="ui header">Add Profile Info</h2>
					<div class="fourteen wide field">
						<label>Name</label> <input type="text" name="name" placeholder="Name">
					</div>
					<div class="fourteen wide field">
						<label>NickName</label> <input type="text" name="nickname" placeholder="NickName">
					</div>
					<div class="fourteen wide field">
						<label>Avatar</label> <input type="file" name="avatar" accept="image/*" placeholder="Avatar">
					</div>
					<div class="fourteen wide field">
						<label>Phone</label> <input type="text" name="phone" placeholder="Phone">
					</div>
					<div class="fourteen wide field">
						<label>Email</label> <input type="text" name="email" placeholder="Email">
					</div>
					<div class="fourteen wide field">
						<label>Address</label> <input type="text" name="address" placeholder="Address">
					</div>
					<div class="fourteen wide field">
						<label>Profession</label> <input type="text" name="profession" placeholder="Profession">
					</div>
					<div class="fourteen wide field">
						<label>Intro</label> 
						<textarea rows="2" name="intro" placeholder="Intro"></textarea>
					</div>
					<input class="ui large teal submit button" type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>