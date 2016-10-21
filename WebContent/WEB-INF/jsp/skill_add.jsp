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
	<div class="main ui container">
	<div class="ui form">
		<div class="inline fields">
			<div class="eight wide field">
				<label>Name</label> <input type="text" placeholder="First Name">
			</div>
			<div class="three wide field">
				<input type="text" placeholder="Middle Name">
			</div>
			<div class="five wide field">
				<input type="text" placeholder="Last Name">
			</div>
		</div>
	</div>
	</div>
	<main>
	<div class="main-wrapper">
		<h1>Add Profile Skill</h1>
		<form action="${pageContext.request.contextPath }/skill/add"
			method="post">
			<div>
				Title: <input type="text" name="title" />
			</div>
			<div>
				Content: <input type="text" name="content" />
			</div>
			<input type="submit" value="Submit" />
		</form>

		<div>
			<table class="striped">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Content</th>
					<th>Operation</th>
				</tr>
				<c:forEach var="item" items="${list }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.content }</td>
						<td><a
							href="${pageContext.request.contextPath }/skill/update/${item.id}">update</a>
							<a
							href="${pageContext.request.contextPath }/skill/delete/${item.id}">delete</a>
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