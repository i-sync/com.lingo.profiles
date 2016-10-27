<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Profile Project</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/project/update" method="post" enctype="multipart/form-data">
					<h2 class="ui header">Add Profile Project</h2>
					<input type="hidden" name="id" value="${form.id }" />
					<div class="ten wide field">
						<label>Title</label> <input type="text" name="title" required
							placeholder="Title" value="${form.title }" >
					</div>
					<div class="ten wide field">
						<label>Image</label> <input type="file" name="image" required
							placeholder="Image">
					</div>
					<div class="ten wide field">
						<label>Link</label> <input type="text" name="link" required
							placeholder="Link" value="${form.link }" >
					</div>
					<div class="ten wide field">
						<label>Tags</label> <input type="text" name="tags" required
							placeholder="Tags" value="${form.tags }" >
					</div>
					<div class="ten wide field">
						<label>Intro</label> 
						<textarea rows="2" name="intro" required placeholder="Intro">${form.intro }</textarea>
					</div>
					<input class="ui large teal submit button" type="submit"
						value="Submit">
				</form>
			</div>
		</div>
		<div class="ui grid">
			<div class="column">
				<table class="ui celled padded table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Image</th>
							<th>Link</th>
							<th>Tags</th>
							<th>Intro</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>
</body>
</html>