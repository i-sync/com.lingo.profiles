<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Profile Project</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/jsp/manage-sidenav.jsp"%>
	<main>
	<div class="main-wrapper">
		<h1>Add Profile Project</h1>
		<form action="${pageContext.request.contextPath }/project/add"
			method="post" enctype="multipart/form-data">
			<div>
				Title: <input type="text" name="title" />
			</div>
			<div>
				Image: <input type="file" name="image" />
			</div>
			<div>
				Link: <input type="text" name="link" />
			</div>
			<div>
				Tags: <input type="text" name="tags" />
			</div>
			<div>
				Intro: <input type="text" name="intro" />
			</div>
			<input type="submit" value="Submit" />
		</form>

		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Image</th>
					<th>Link</th>
					<th>Tags</th>
					<th>Intro</th>
					<th>Operation</th>
				</tr>
				<c:forEach var="item" items="${list }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td><img src="data:image/jpg;base64,${item.projectImage }"
							style="width: 100px; height: 100px;" /></td>
						<td><a href="${item.link}">${item.link }</a></td>
						<td>${item.tags }</td>
						<td>${item.intro }</td>
						<td><a
							href="${pageContext.request.contextPath }/project/update/${item.id}">update</a>
							<a
							href="${pageContext.request.contextPath }/project/delete/${item.id}">delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</main>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>