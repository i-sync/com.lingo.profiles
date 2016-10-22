<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Your Account</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
<style type="text/css">
	.circular.segment {
		cursor: pointer;
	}
	/* Mobile Sizing Combinations */
	@media only screen and (min-width: 320px) and (max-width: 767px) {
		.circular.segment{
			width:200px;
			height:200px;
		}
	}
	/* Tablet Sizing Combinations */
	@media only screen and (min-width: 768px) and (max-width: 991px) {
		.circular.segment{
			width:250px;
			height:250px;
		}
	}
	/* Computer/Desktop Sizing Combinations */
	@media only screen and (min-width: 992px) {
		.circular.segment{
			width:300px;
			height:300px;
		}
	}
</style>
</head>
<body>
	<!-- Page Contents -->
	<div></div>
	<div class="ui header">
		<h1 class="ui center aligned header">Manage Your Account</h1>
	</div>
	<div class="ui grid container">
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="skill" class="ui inverted blue circular  segment">
					<h2 class="ui header">Skill</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="experience" class="ui inverted green circular  segment">
					<h2 class="ui header">Experience</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="project" class="ui inverted red circular  segment">
					<h2 class="ui header">Project</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="education" class="ui inverted purple circular  segment">
					<h2 class="ui header">Education</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="living" class="ui inverted teal circular  segment">
					<h2 class="ui header">Living</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="link" class="ui inverted olive circular  segment">
					<h2 class="ui header">Link</h2>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
	<script>
		$(function(){
			$(".circular.segment").mouseenter(function(){
				$(this).transition('jiggle');				
			}).click(function(){
				var id = $(this).attr('id');
				var url ="${pageContext.request.contextPath }/" + id + "/add";
				window.location.href = url;
			});			
		});
	</script>
</body>
</html>