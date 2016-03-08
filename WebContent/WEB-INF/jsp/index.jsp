<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="container-fluid">
			<h1 class="h1-responsive">Profile</h1>
			<div class="col-md-6">
				<h3 class="h3-responsive">我是 ${form.nickName }(${form.name})</h3>
				<h3 class="h3-responsive"><i class="fa fa-phone fa-lg"></i>&nbsp;&nbsp;<a href="callto:${form.phone }">${form.phone }</a></h3>
				<h3 class="h3-responsive"><i class="fa fa-envelope"></i>  &nbsp;&nbsp;<a href="mailto:${form.email}">${form.email }</a></h3>
				<h3 class="h3-responsive"><i class="fa fa-map-marker fa-lg"></i>&nbsp;&nbsp;${form.address }</h3>
				<i class="fa fa-user fa-4x"></i>&nbsp;&nbsp;&nbsp;&nbsp;${form.intro }
			</div>
			<div class="col-md-6">
				<img src="data:image/jpg;base64,${form.avatarImage }"
					class="materialboxed img-responsive z-depth-2" width="500px;" />
			</div>
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
								<a href="#0" class="cd-read-more">Read more</a>
							 <span class="cd-date">Jan 14</span>
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
								<a href="${item.link }" class="cd-read-more">Read more</a>
							 <span class="cd-date">${item.period }</span>
						</div>
						<!-- cd-timeline-content -->
					</div>
				</c:forEach>
				<!-- cd-timeline-block -->

			</section>
		</div>
		
		<div id="link" class="container-fluid">
			<h1 class="h1-responsive">Social Links</h1>
			<c:forEach var="item" items="${form.link }">
				<a href="${item.link }" class="btn-sm-full fb-bg rectangle waves-effect waves-light"><i class="fa fa-facebook"> </i> <span>${item.title }</span> </a>
			</c:forEach>
		</div>
	</div>
	</main>

	<!--<h1></h1>
	<div>
		<div>
			<h3>Profile info</h3>
			<div>
				Name: <label>${form.name }</label>
			</div>
			<div>
				Avatar: <img src="data:image/jpg;base64,${form.avatarImage }"
					style="width: 200px; height: 200px" />
			</div>
			<div>Phone:${form.phone }</div>
			<div>Email:${form.email }</div>
			<div>Address:${form.address }</div>
			<div>Intro:${form.intro }</div>
		</div>
		<h3>Skill</h3>
		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Content</th>
				</tr>
				<c:forEach var="item" items="${form.skill }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.content }</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<h3>Project</h3>
		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Image</th>
					<th>Link</th>
					<th>Tags</th>
					<th>Intro</th>
				</tr>
				<c:forEach var="item" items="${form.project }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td><img src="data:image/jpg;base64,${item.projectImage }"
							style="width: 100px; height: 100px;" /></td>
						<td><a href="${item.link}">${item.link }</a></td>
						<td>${item.tags }</td>
						<td>${item.intro }</td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<h3>Education</h3>
		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Period</th>
					<th>Professional</th>
					<th>Link</th>
					<th>Intro</th>
				</tr>
				<c:forEach var="item" items="${form.education }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.period }</td>
						<td>${item.professional }</td>
						<td>${item.link }</td>
						<td>${item.intro }</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<h3>Living</h3>
		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Content</th>
				</tr>
				<c:forEach var="item" items="${form.living }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.content }</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<h3>Link</h3>
		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Link</th>
					<th>Logo</th>
				</tr>
				<c:forEach var="item" items="${form.link }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td><a href="${item.link}">${item.link }</a></td>
						<td><img src="data:image/jpg;base64,${item.logoImage }"
							style="width: 50px; height: 50px;" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div-->
	<%@include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>