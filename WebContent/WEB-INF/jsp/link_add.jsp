<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Profile Link</title>
</head>
<body>
	<h1>Add Profile Link</h1>
	<form action="${pageContext.request.contextPath }/link/add"
		method="post" enctype="multipart/form-data">
		<div>
			Title: <input type="text" name="title" />
		</div>
		<div>
			Link: <input type="text" name="link" />
		</div>
		<div>
			Logo: <input type="file" name="logo" />
		</div>
		<input type="submit" value="Submit" />
	</form>
	<div>
		aaaa:${list.size() }
	</div>
	<div>
		<table class="striped">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Link</th>
				<th>Logo</th>
				<th>Operation</th>
			</tr>
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>${item.title }</td>
					<td>
						<a href="${item.link}">${item.link }</a>
					</td>
					<td>
						<img src="data:image/jpg;base64,${item.logoImage }" style="width:50px;height:50px;"/>
					</td>
					<td>
					<a href="${pageContext.request.contextPath }/link/update/${item.id}">update</a> 
					<a href="${pageContext.request.contextPath }/link/delete/${item.id}">delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>