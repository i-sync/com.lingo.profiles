<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile Skill</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/skill/add" method="post">
					<h2 class="ui header">Add Profile Skill</h2>
					<div class="ten wide field">
						<label>Title</label> <input type="text" name="title"
							placeholder="Title">
					</div>
					<div class="ten wide field">
						<label>Content</label> 
						<textarea rows="2" name="content" placeholder="Content"></textarea>
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
							<th>Title</th>
							<th>Content</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list }">
							<tr>
								<td>${item.title }</td>
								<td>${item.content }</td>
								<td>
									<a href="${pageContext.request.contextPath }/skill/update/${item.id}">update</a>
									&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath }/skill/delete/${item.id}">delete</a>
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