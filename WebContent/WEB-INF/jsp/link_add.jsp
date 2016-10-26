<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile Link</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
</head>
<body>
	<div class="main ui container masthead vertical segment">
		<div class="ui grid">
			<div class="column">
				<form class="ui form" action="${pageContext.request.contextPath }/link/add" method="post">
					<h2 class="ui header">Add Profile Link</h2>
					<div class="ten wide field">
						<label>Title</label> <input type="text" name="title" required
							placeholder="Title">
					</div>
					<div class="ten wide field">
						<label>Link</label> <input type="text" name="link" required
							placeholder="Link">
					</div>
					<div class="grouped fields">
						<label>Icon</label>
						<c:forEach var="item" items="${social }">
							<div class="field">
						      <div class="ui radio checkbox">
						        <input type="radio" name="icon" value="${item.icon }|${item.bg}">
						        <label><i class="${item.icon } large icon"> </i>${item.name }</label>
						      </div>
						    </div>
						</c:forEach>
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
							<th>Link</th>
							<th>Icon</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list }">
							<tr>
								<td>${item.id }</td>
								<td>${item.title }</td>
								<td><a href="${item.link}">${item.link }</a></td>
								<td>
									<a href="${item.link }" class="btn-sm-full ${fn:split(item.icon,'|')[1] } rectangle waves-effect waves-light">
										<i class="${fn:split(item.icon,'|')[0] } icon"> </i> 
										<span>${item.title }</span>
									</a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath }/link/update/${item.id}">update</a>
									<a href="${pageContext.request.contextPath }/link/delete/${item.id}">delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/manage-footer.jsp" %>
</body>
</html>