<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Profile Experience</title>
</head>
<body>
	<h1>Add Profile Experience</h1>
	<form action="${pageContext.request.contextPath }/experience/add"
		method="post">
		<div>
			Title: <input type="text" name="title" />
		</div>
		<div>
			Company: <input type="text" name="company" />
		</div>
		<div>
			Link: <input type="text" name="link" />
		</div>
		<div>
			Period: <input type="text" name="period" />
		</div>
		<div>
			Location: <input type="text" name="location" />
		</div>
		<div>
			Position: <input type="text" name="position" />
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
				<th>Company</th>
				<th>Link</th>
				<th>Period</th>
				<th>Location</th>
				<th>Position</th>
				<th>Intro</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>${item.company }</td>
					<td>${item.link }</td>
					<td>${item.period }</td>
					<td>${item.location }</td>
					<td>${item.position }</td>
					<td>${item.intro }</td>
					<td>
					<a href="${pageContext.request.contextPath }/experience/update/${item.id}">update</a> 
					<a href="${pageContext.request.contextPath }/experience/delete/${item.id}">delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>