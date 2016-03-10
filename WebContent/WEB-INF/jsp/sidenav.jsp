<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- SideNav slide-out button -->
<a href="#" data-activates="slide-out"
	class="navbar-brand button-collapse"><i class="material-icons">menu</i></a>
<!--/. SideNav slide-out button -->
<style>
<!--
#avatar{
	background-image:url(data:image/jpg;base64,${form.avatarImage});
	background-repeat: no-repeat;
    background-position: 50%;
    border-radius: 50%;
    width: 100%;
    padding-bottom:100%;
    background-size: cover;
}
-->
</style>
<!-- Sidebar navigation -->
<ul id="slide-out"
	class="side-nav fixed personal-side-nav stylish-side-nav">
	<!-- Logo -->
	<div class="logo-wrapper">
		<a href="#">
			<div id="avatar" class="avatar-wrapper">
				<!--img
					src="data:image/jpg;base64,${form.avatarImage }"
					class="img-responsive img-circle"-->
			</div>
		</a>
	</div>
	<!--/. Logo -->

	<!--About
	<div class="about">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	</div>
	/.About-->

	<!-- Side navigation links -->
	<ul class="collapsible collapsible-accordion">
		<li><a href="#profile" class="collapsible-header waves-effect waves-light"><i class="fa fa-user"></i>Profile</a></li>
		<li><a href="#skill" class="collapsible-header waves-effect waves-light"><i class="fa fa-cubes"></i>Skill</a></li>
		<li><a href="#experience" class="collapsible-header waves-effect waves-light"><i class="fa fa-briefcase"></i>Experience</a></li>
		<li><a href="#project" class="collapsible-header waves-effect waves-light"><i class="fa fa-trophy"></i>Project</a></li>
		<li><a href="#education" class="collapsible-header waves-effect waves-light"><i class="fa fa-graduation-cap"></i>Education</a></li>
		<li><a href="#living" class="collapsible-header waves-effect waves-light"><i class="fa fa-home"></i>Living</a></li>
		<li><a href="#link" class="collapsible-header waves-effect waves-light"><i class="fa fa-user-plus"></i>Link</a></li>
	</ul>
	<!--/. Side navigation links -->
</ul>