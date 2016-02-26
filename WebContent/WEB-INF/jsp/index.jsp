<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Webcome to com.lingo.profiles</h1>
	<div>
		<h3>Profile info</h3>
		<div>
			Name:
			<label>${form.name }</label>
		</div>
		<div>
			Avatar:
			<img src="data:image/jpg;base64,${form.avatarImage }" style="width:200px;height:200px"/>
		</div>
		<div>
			Phone:${form.phone }
		</div>
		<div>
			Email:${form.email }
		</div>
		<div>
			Address:${form.address }
		</div>
		<div>
			Intro:${form.intro }
		</div>
	</div>
</body>
</html>