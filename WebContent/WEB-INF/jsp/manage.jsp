<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Your Account</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
<style type="text/css">
	.ui.circular.segment {
		margin:.5em;
		cursor: pointer;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	/* Mobile Sizing Combinations */
	@media only screen and (min-width: 320px) and (max-width: 767px) {
		.circular.segment{
			width:80%;
			height:100px;
		}		
		
		h1.ui.header{
			margin-top:1em;
			font-size:2.5em;
		}
	}
	/* Tablet Sizing Combinations */
	@media only screen and (min-width: 768px) and (max-width: 991px) {
		.circular.segment{
			width:250px;
			height:250px;
		}
		
		h1.ui.header{
			margin-top:1em;
			font-size:3em;
		}
	}
	/* Computer/Desktop Sizing Combinations */
	@media only screen and (min-width: 992px) {
		.circular.segment{
			width:300px;
			height:300px;
		}
		
		h1.ui.header{
			margin-top:1em;
			font-size:3.5em;
		}
	}
	.ui.container{
		margin-top:1em;
		min-width:325px;
	}
</style>
</head>
<body>
	<!-- Page Contents -->
	<div></div>
	<h1 class="ui center aligned teal inverted header">
		Manage Your Account
	</h1>
	<div class="ui divider"></div>
	<div class="ui grid container">
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="skill" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
					<h2 class="ui header">Skill</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="experience" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
					<h2 class="ui header">Experience</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="project" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
					<h2 class="ui header">Project</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="education" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
					<h2 class="ui header">Education</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="living" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
					<h2 class="ui header">Living</h2>
				</div>
			</div>
		</div>
		<div
			class="five wide computer eight wide tablet sixteen wide mobile column">
			<div class="ui center aligned grid">
				<div id="link" class="ui inverted ${colors[random.nextInt(10)] } circular  segment">
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