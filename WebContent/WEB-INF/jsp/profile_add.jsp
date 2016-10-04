<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/jsp/manage-sidenav.jsp"%>
	<main>
	<div class="main-wrapper">
		<h3>Add Profile Info</h3>
		<div class="row">
			<form class="col-md-12"
				action="${pageContext.request.contextPath }/profile/add"
				method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="input-field col-md-12">
						<input id="name" type="text" name="name" class="validate" required />
						<label for="name" data-success="right" data-error="${form.errors.name }">Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<input id="nickname" type="text" name="nickName" class="validate" required />
						<label for="nickname">NickName</label>
					</div>
				</div>
				<div class="row">
					<div class="file-field input-field col-md-12">
						<!--button type="button" class="btn btn-default waves-effect waves-light">
							<span>Avatar</span>
							<input type="file" name="avatar" class="validate" />
						</button-->
						<input class="file-path validate" type="text" readonly />
						<div class="btn btn-default">
							<span>Avatar</span>
							<input type="file" name="avatar" accept="image/*" class="validate" required />
						</div>
						<!--input id="input-avatar" type="file" name="avatar" class="validate" />
						<label for="input-avatar">Avatar</label-->
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<input id="phone" type="text" name="phone" class="validate" required />
						<label for="phone">Phone</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<input id="email" type="text" name="email" class="validate" required />
						<label for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<input id="address" type="text" name="address" class="validate" required />
						<label for="address">Address</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<input id="profession" type="text" name="profession" class="validate" required />
						<label for="profession">Profession</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col-md-12">
						<textarea id="intro" name="intro" class="materialize-textarea"></textarea>
						<label for="intro">Intro</label>
					</div>
				</div>
				<button type="submit" class="btn btn-default waves-effect waves-light">
					Submit
				</button>
			</form>
		</div>
	</div>
	</main>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>