<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile</title>
<%@include file="/WEB-INF/jsp/header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/jsp/sidenav.jsp"%>
	<main>
	<div class="main-wrapper">
		<div id="profile" class="container-fluid">
			<h1 class="h1-responsive">Profile</h1>
			<div class="col-md-6">
				<h3 class="h3-responsive">我是 ${form.nickName }(${form.name})</h3>
				<h3 class="h3-responsive col-xs-2 col-md-2"><i class="fa fa-phone fa-lg"></i></h3><h3 class="h3-responsive col-xs-10 col-md-10"><a href="callto:${form.phone }">${form.phone }</a></h3>
				<h3 class="h3-responsive col-xs-2 col-md-2"><i class="fa fa-envelope"></i></h3><h3 class="h3-responsive col-xs-10 col-md-10"><a href="mailto:${form.email}">${form.email }</a></h3>
				<h3 class="h3-responsive col-xs-2 col-md-2"><i class="fa fa-map-marker fa-lg"></i></h3><h3 class="h3-responsive col-xs-10 col-md-10">${form.address }</h3>
				<h3 class="h3-responsive col-xs-2 col-md-2"><i class="fa fa-user fa-lg"></i></h3><h5 class="h5-responsive col-xs-10 col-md-10">${form.intro }</h5>
			</div>
			<div class="col-md-6">
				<img src="data:image/jpg;base64,${form.avatarImage }"
					class="materialboxed img-responsive z-depth-2" width="650" />
			</div>
		</div>
		
		<div id="skill" class="container-fluid">
			<h1 class="h1-responsive">Skill</h1>
			<div class="panel-group">
				<c:forEach var="item" items="${form.skill }">
					<div class="panel panel-default">
						<div class="panel-body">${item.title}. ${item.content }</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div id="experience" class="container-fluid">
			<h1 class="h1-responsive">Experience</h1>
			<section id="cd-timeline" class="cd-container">
				<c:forEach var="item" items="${form.experience }">
					<div class="cd-timeline-block">
						<div class="cd-timeline-img  cd-location ">
							<img src="${pageContext.request.contextPath}/img/icon-location.svg" alt="Picture">
						</div>
						<!-- cd-timeline-img -->
		
						<div class="cd-timeline-content z-depth-2 hoverable">
							<h2 class="h2-responsive">${item.company }</h2>
							<p>${item.position }</p>
							<p>${item.location }</p>
							<p>${item.intro }</p>
								<a href="${item.link }" target="_blank" class="cd-read-more">Read more</a>
							 <span class="cd-date">${item.period }</span>
						</div>
						<!-- cd-timeline-content -->
					</div>
				</c:forEach>
				<!-- cd-timeline-block -->

			</section>
		</div>
		
		<div id="project" class="container-fluid">
			<h1 class="h1-responsive">Project</h1>
			<section id="cd-timeline" class="cd-container">
				<c:forEach var="item" items="${form.project }">
					<div class="cd-timeline-block">
						<div class="cd-timeline-img  cd-location ">
							<img src="${pageContext.request.contextPath}/img/icon-location.svg" alt="Picture">
						</div>
						<!-- cd-timeline-img -->
		
						<div class="cd-timeline-content z-depth-2 hoverable">
							<h2 class="h2-responsive">${item.title }</h2>
							<p>${item.intro }</p>
								<a href="${item.link }" target="_blank" class="cd-read-more">Read more</a>
							 <span class="cd-date">${item.tags }</span>
						</div>
						<!-- cd-timeline-content -->
					</div>
				</c:forEach>
				<!-- cd-timeline-block -->

			</section>
		</div>
		
		<div id="education" class="container-fluid">
			<h1 class="h1-responsive">Education</h1>
			<section id="cd-timeline" class="cd-container">
				<c:forEach var="item" items="${form.education }">
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-location ">
							<img src="${pageContext.request.contextPath}/img/icon-location.svg" alt="Picture">
						</div>
						<!-- cd-timeline-img -->
		
						<div class="cd-timeline-content z-depth-2 hoverable">
							<h2 class="h2-responsive">${item.title }</h2>
							<p>${item.professional }</p>
							<p>${item.intro }</p>
								<a href="${item.link }" target="_blank" class="cd-read-more">Read more</a>
							 <span class="cd-date">${item.period }</span>
						</div>
						<!-- cd-timeline-content -->
					</div>
				</c:forEach>
				<!-- cd-timeline-block -->

			</section>
		</div>
		
		<div id="living" class="container-fluid">
			<h1 class="h1-responsive">Living</h1>
			<div class="container">
				<c:forEach var="item" items="${form.living }">
					<div class="chip z-depth-2" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${item.content }"><span>${item.title }</span></div>
				</c:forEach>
			</div>
		</div>
		
		<div id="link" class="container-fluid">
			<h1 class="h1-responsive">Social Links</h1>
			<div class="container">
			<c:forEach var="item" items="${form.link }">
				<a href="${item.link }" class="btn-sm-full ${fn:split(item.icon,'|')[1] } rectangle waves-effect waves-light"><i class="fa fa-${fn:split(item.icon,'|')[0] }"> </i> <span>${item.title }</span> </a>
			</c:forEach>
			</div>
		</div>
	</div>
	</main>

	<%@include file="/WEB-INF/jsp/footer.jsp"%>
	<script>
		$(document).ready(function(){
		    $('[data-toggle="tooltip"]').tooltip({animation: true, delay: {show: 300, hide: 300}}); 
		});
	</script>
</body>
</html>