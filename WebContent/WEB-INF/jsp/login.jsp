<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Lingo Profile</title>
<%@include file="/WEB-INF/jsp/manage-header.jsp"%>
<style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
</style>


</head>
<body>
	<div class="ui middle aligned center aligned grid">
	  <div class="column">
		<h2 class="ui teal image header">
		  <!--img src="assets/images/logo.png" class="image"-->
		  <div class="content">
			Log-in to lingo profile
		  </div>
		</h2>
		<form class="ui large form" action="${pageContext.request.contextPath }/login" method="post">
		  <div class="ui stacked segment">
			<div class="field">
			  <div class="ui left icon input">
				<i class="user icon"></i>
				<input type="text" name="phone" placeholder="Username / Phone / Email" value="tianzhenyun">
			  </div>
			</div>
			<div class="field">
			  <div class="ui left icon input">
				<i class="lock icon"></i>
				<input type="password" name="password" placeholder="Password" value="123">
			  </div>
			</div>
			<input class="ui fluid large teal submit button" type="submit" value="Login">
		  </div>

		  <div class="ui error message"></div>

		</form>

	  </div>
	</div>
	
	<%@include file="/WEB-INF/jsp/manage-footer.jsp"%>	
	<script>
	  $(document).ready(function() {
		  $('.ui.form').form({
			  fields: {
				phone: {
				  identifier  : 'phone',
				  rules: [
					{
					  type   : 'empty',
					  prompt : 'Please enter your username'
					}
				  ]
				},
				password: {
				  identifier  : 'password',
				  rules: [
					{
					  type   : 'empty',
					  prompt : 'Please enter your password'
					},
					{
					  type   : 'length[3]',
					  prompt : 'Your password must be at least 3 characters'
					}
				  ]
				}
			  }
			});
		});
	</script>
</body>
</html>