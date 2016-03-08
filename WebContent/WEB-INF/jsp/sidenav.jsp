<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- SideNav slide-out button -->
<a href="#" data-activates="slide-out"
	class="navbar-brand button-collapse"><i class="material-icons">menu</i></a>
<!--/. SideNav slide-out button -->

<!-- Sidebar navigation -->
<ul id="slide-out"
	class="side-nav fixed personal-side-nav stylish-side-nav">
	<!-- Logo -->
	<div class="logo-wrapper">
		<a href="#">
			<div class="avatar-wrapper">
				<img
					src="data:image/jpg;base64,${form.avatarImage }"
					class="img-responsive img-circle">
			</div>
		</a>
	</div>
	<!--/. Logo -->

	<!--About-->
	<div class="about">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	</div>
	<!--/.About-->

	<!-- Side navigation links -->
	<ul class="collapsible collapsible-accordion">
		<li><a href="#skill" class="collapsible-header waves-effect waves-light">Skill</a></li>
		<li><a href="#project" class="collapsible-header waves-effect waves-light">Project</a></li>
		<li><a href="#education" class="collapsible-header waves-effect waves-light">Education</a></li>
		<li><a href="#living" class="collapsible-header waves-effect waves-light">Living</a></li>
		<li><a href="#link" class="collapsible-header waves-effect waves-light">Link</a></li>
	</ul>
	<!--/. Side navigation links -->
</ul>