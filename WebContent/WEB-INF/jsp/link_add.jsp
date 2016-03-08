<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile Link</title>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
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
			Icon:
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Social Icon <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" name="icon">
					<li><a class="btn-sm-full qq-bg rectangle waves-effect waves-light"><i class="fa fa-qq"> </i><span>qq</span> </a></li>
					<li><a class="btn-sm-full wb-bg rectangle waves-effect waves-light"><i class="fa fa-weibo"> </i><span>weibo</span> </a></li>
					<li><a class="btn-sm-full wc-bg rectangle waves-effect waves-light"><i class="fa fa-wechat"> </i><span>wechat</span> </a></li>
					<li><a class="btn-sm-full tw-bg rectangle waves-effect waves-light"><i class="fa fa-tencent-weibo"> </i><span>tencent-weibo</span> </a></li>
					<li><a class="btn-sm-full rr-bg rectangle waves-effect waves-light"><i class="fa fa-renren"> </i><span>renren</span> </a></li>
					<li><a class="btn-sm-full fb-bg rectangle waves-effect waves-light"><i class="fa fa-facebook"> </i><span>Facebook</span> </a></li>
					<li><a class="btn-sm-full tw-bg rectangle waves-effect waves-light"><i class="fa fa-twitter"> </i><span>twitter</span> </a></li>
					<li><a class="btn-sm-full gplus-bg rectangle waves-effect waves-light"><i class="fa fa-google-plus"> </i><span>  google +</span> </a></li>
					<li><a class="btn-sm-full yt-bg rectangle waves-effect waves-light"><i class="fa fa-youtube"> </i><span>youtube</span> </a></li>
					<li><a class="btn-sm-full git-bg rectangle waves-effect waves-light"><i class="fa fa-github"> </i><span>github</span> </a></li>
					<li><a class="btn-sm-full wa-bg rectangle waves-effect waves-light"><i class="fa fa-whatsapp"> </i><span>whatsapp</span> </a></li>
				</ul>
			</div>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="qq"><a class="btn-sm-full qq-bg rectangle waves-effect waves-light"><i class="fa fa-qq"> </i></a>
			</label>
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="weibo"><a class="btn-sm-full wb-bg rectangle waves-effect waves-light"><i class="fa fa-weibo"></i></a>
			</label>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="wechat"><a class="btn-sm-full wc-bg rectangle waves-effect waves-light"><i class="fa fa-wechat"> </i></a>
			</label>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="tencent-weibo"><a class="btn-sm-full tw-bg rectangle waves-effect waves-light"><i class="fa fa-tencent-weibo"> </i></a>
			</label>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="renren"><a class="btn-sm-full rr-bg rectangle waves-effect waves-light"><i class="fa fa-renren"> </i></a>
			</label>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="facebook"><a class="btn-sm-full fb-bg rectangle waves-effect waves-light"><i class="fa fa-facebook"> </i></a>
			</label>
			
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="twitter"><a class="btn-sm-full tw-bg rectangle waves-effect waves-light"><i class="fa fa-twitter"> </i></a>
			</label>
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="google-plus"><a class="btn-sm-full gplus-bg rectangle waves-effect waves-light"><i class="fa fa-google-plus"> </i></a>
			</label>
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="youtube"><a class="btn-sm-full gplus-bg rectangle waves-effect waves-light"><i class="fa fa-youtube"> </i></a>
			</label>
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="github"><a class="btn-sm-full git-bg rectangle waves-effect waves-light"><i class="fa fa-github"> </i></a>
			</label>
			<label class="radio-inline">
				<input type="radio" name="socialicon" value="whatsapp"><a class="btn-sm-full wa-bg rectangle waves-effect waves-light"><i class="fa fa-whatsapp"> </i></a>
			</label>
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
	
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>