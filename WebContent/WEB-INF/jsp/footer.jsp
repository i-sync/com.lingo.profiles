<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/mdb.min.js"></script>
	<script>
		// Initialize collapse button
		$(".button-collapse").sideNav();
		// Initialize collapsible (uncomment the line below if you use the dropdown variation)
		$('.collapsible').collapsible();
	</script>
</body>
</html>