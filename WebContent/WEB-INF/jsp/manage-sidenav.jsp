<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
<!--
#avatar {
	background-image: url(data:image/jpg;base64,${user.avatarImage});
	background-repeat: no-repeat;
	background-position: 50%;
	border-radius: 50%;
	width: 100%;
	padding-bottom: 100%;
	background-size: cover;
}
-->
</style>
</head>
<body>
<!-- Sidebar navigation -->
	<ul id="slide-out"
		class="side-nav fixed personal-side-nav stylish-side-nav">
		<!-- Logo -->
		<div class="logo-wrapper">
			<a href="#">
				<div id="avatar" class="avatar-wrapper">
					
				</div>
			</a>
		</div>
		<!--/. Logo -->
		<div class="about">
			<p>Lingo Profile Management</p>
		</div>

		<!-- Side navigation links -->
		<ul class="collapsible collapsible-accordion">
			<li><a href="${pageContext.request.contextPath }/profile/update/${user.id}"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-user"></i>Profile</a></li>
			<li><a href="${pageContext.request.contextPath }/skill/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-cubes"></i>Skill</a></li>
			<li><a href="${pageContext.request.contextPath }/experience/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-briefcase"></i>Experience</a></li>
			<li><a href="${pageContext.request.contextPath }/project/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-trophy"></i>Project</a></li>
			<li><a href="${pageContext.request.contextPath }/education/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-graduation-cap"></i>Education</a></li>
			<li><a href="${pageContext.request.contextPath }/living/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-home"></i>Living</a></li>
			<li><a href="${pageContext.request.contextPath }/link/add"
				class="collapsible-header waves-effect waves-light"><i
					class="fa fa-user-plus"></i>Link</a></li>
		</ul>
		<!--/. Side navigation links -->
	</ul>
</body>
</html>