<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath }/static/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/static/js/mdb.min.js"></script>
<script>
	// Initialize collapse button
	$(".button-collapse").sideNav();
	// Initialize collapsible (uncomment the line below if you use the dropdown variation)
	$('.collapsible').collapsible();

	$("#contact-form :input[type=text]").blur(function(){
		if($(this).val().trim()=="")
			$(this).addClass("invalid");
	});
	//send email
	$("#contact-form").on("click", "#send-message", function(click) {
		//first check 		
		var form = $("#contact-form");
		var data = {};
		var name = form.find("#contact-name").val().trim();
		var email = form.find("#contact-mail").val().trim();
		//var subject = form.find("#contact-subject").val().trim();
		var message = form.find("#contact-message").val().trim();
		/*
		if(name=="")
			form.find("#contact-name").addClass("invalid");
		if(email=="")
			form.find("#contact-mail").addClass("invalid");
		if(subject=="")
			form.find("#contact-subject").addClass("invalid");
		if($("#contact-form .invalid").length>0)
			return;
		*/
		
		data["name"] = name;
		data["email"] = email;
		//data["subject"] = subject;
		data["message"] = message;

		$.ajax({
			url : "${pageContext.request.contextPath}/email/send",
			type : "POST",
			contentType : "application/json",
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			data : JSON.stringify(data),
			success : function(res) {
				//console.log(res.errors);
				if (res.result || res.result == "true") {
					alert("Thanks for your feedback!");
					console.log("success");
					//$("#contact-form .modal-header button").click();
					$("#contact-form input").val("");
					$("#contact-from textarea").val("");
					$("#contact-from input#send-message").attr("disabled","disabled");
				} else {
					console.log(res.errors);
					if(res.errors.name!=undefined)
					{
						$("#contact-form #contact-name").addClass("invalid").attr("title",res.errors.name);
					}
					if(res.errors.email!=undefined)
					{
						$("#contact-form #contact-mail").addClass("invalid").attr("title",res.errors.email);
					}
					if(res.errors.message!=undefined)
					{
						$("#contact-form #contact-subject").addClass("invalid").attr("title",res.errors.subject);
					}
				}
			},
			error : function(res) {
				console.log(res);
			},
			dataType : "json"
		});
		
		return false;
	});
</script>
<footer class="page-footer blue center-on-small-only">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<h5 class="white-text">About Profile</h5>
				<p class="grey-text text-lighten-4">This is a Personal Profile
					Shower</p>
			</div>
			<div class="col-md-6">
				<h5 class="white-text">Links</h5>
				<ul>
					<li><a class="grey-text text-lighten-3" target="_blank"
						href="http://mdbootstrap.com/">Material Design</a></li>
					<li><a class="grey-text text-lighten-3" target="_blank"
						href="//contact.nuclearengine.cn/">Contacts 09</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright text-center rgba-black-light">
		<div class="container-fluid">
			© 2016 Copyright: <a href="//nuclearengine.cn"> profile </a>
		</div>
	</div>
</footer>