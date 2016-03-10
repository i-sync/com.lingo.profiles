<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/js/mdb.min.js"></script>
<script>
	// Initialize collapse button
	$(".button-collapse").sideNav();
	// Initialize collapsible (uncomment the line below if you use the dropdown variation)
	$('.collapsible').collapsible();
</script>
<footer class="page-footer blue center-on-small-only">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<h5 class="white-text">About Profile</h5>
				<p class="grey-text text-lighten-4">This is a Personal Profile Shower</p>
			</div>
			<div class="col-md-6">
				<h5 class="white-text">Links</h5>
				<ul>
					<li><a class="grey-text text-lighten-3" target="_blank" href="http://mdbootstrap.com/">Material Design</a></li>
					<li><a class="grey-text text-lighten-3" target="_blank" href="http://www.contacts09.ml/">Contacts 09</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright text-center rgba-black-light">
		<div class="container-fluid">
			© 2016 Copyright: <a href="http://www.profile.com">
				profile </a>
		</div>
	</div>
</footer>