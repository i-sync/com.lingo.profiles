<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profiles</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Profile,New Design" />
<script type="applisalonion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel='stylesheet'/>
<link href="${pageContext.request.contextPath }/css/style.new.css" rel='stylesheet' />	
<link href="${pageContext.request.contextPath }/css/swipebox.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel='stylesheet' />	
<!--//Custom Theme files-->
<style>
	input.invalid
	{
		color:red;
	}
</style>
<!--web-font-->
<link href="${pageContext.request.contextPath }/css/fontstyle.css" rel='stylesheet' />
<link href="${pageContext.request.contextPath }/css/fontgoogle.css" rel='stylesheet'/>
<!--//web-font-->

<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<!--banner-->
<div class="banner">
	<div class="container">
		<div class="col-md-4 b-part1">
			<img src="data:image/jpg;base64,${form.avatarImage }" alt="" />
			<h1>${from.nickName }</h1>
			<h2>${form.profession}</h2>
		</div>
		
		<div class="col-md-4 b-part3">
			<h3>Follow</h3>
			<!--a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-pinterest-p" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-vimeo" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
			<a href="#"><i class="fa fa-tumblr" aria-hidden="true"></i></a-->
			<c:forEach var="item" items="${form.link }">
				<a href="${item.link }" class="btn-sm-full ${fn:split(item.icon,'|')[1] } rectangle waves-effect waves-light"><i class="fa fa-${fn:split(item.icon,'|')[0] }"> </i>  </a>
			</c:forEach>
		</div>
		<div class="col-md-4 b-part2">
			<h3>Contact</h3>
			<h4><a href="#">${form.email }</a></h4>
			<h4 class="agile">${form.phone }</h4>
			<h4>${form.address }</h4>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--//banner-->

<!--about-->
<div class="about">
	<div class="container">
		<h3>About Me</h3>
		<label class="line"></label>
		<img src="data:image/jpg;base64,${form.avatarImage }" alt=" " />
		<p>${form.intro}</p>
	</div>
</div>
<!--//about-->


<!--skills-->
<div class="skills">
	<div class="container">
		<h3>My Skills</h3>
		<label class="line"></label>
			<div class="col-md-6 skills-left">
				<c:forEach var="item" varStatus="loop" items="${form.skill }">
					<c:if test="${loop.index le fn:length(form.skill)/2}">
						<p>${item.title }. ${item.content }</p>
					</c:if>
				</c:forEach>
			</div>
			<div class="col-md-6 skills-left">
				<c:forEach var="item" varStatus="loop" items="${form.skill }">
					<c:if test="${loop.index gt fn:length(form.skill)/2}">
						<p>${item.title }. ${item.content }</p>
					</c:if>
				</c:forEach>
			</div>
			<div class="clearfix"></div>
	</div>
</div>
<!--/skills-->

<div class="education">
	  <div class="container">
			<div class="edu-devide clearfix">
				<h3>Education</h3>
				<div class="edu-devide-div">
					<c:forEach var="item" varStatus="loop" items="${form.education }">
						<div class="edu-devide-box <c:if test='${loop.index % 2 == 1 }'>clearfix</c:if>">
							<div class="bag"></div>
							<div class="edu-devide-grid">
								<h2 class="h2-responsive">${item.title }</h2>
								<p>${item.professional }</p>
								<p>${item.intro }</p>
								<a href="${item.link }" target="_blank" class="cd-read-more">Read more</a>
								<span class="cd-date">${item.period }</span>
						    </div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>	
	</div>
	
<!--- Education Ends Here --->

<!-- projects -->
<div class="experience">
	<div class="container">
	   <h3>Experience</h3>
	   <label class="line"></label>
		<div class="span9 columns">
          <ul id="feature-tab" class="nav nav-tabs">
            <c:forEach var="item" varStatus="loop" items="${form.experience }">
            	<li class="${loop.index eq 0 ? 'active':'' }">
            		<a href="#experience${loop.index }" data-toggle="tab" role="tab">${item.company }</a>
            	</li>
            </c:forEach>
          </ul>
          <div id="myTabContent" class="tab-content">
          	<c:forEach var="item" varStatus="loop" items="${form.experience }">
				<div class="tab-pane fade ${loop.index eq 0? 'active in':'' }" id="experience${loop.index }">
					<div class="row feature">
						<div class="col-md-12">
							<h2 class="feature-heading">
								${item.company }
								<span class="text-muted">${item.period }</span>
							</h2>
							<p class="text-left">${item.position }</p>
							<p class="text-left">
								<span>${item.intro }</span>
								<span class="text-muted"><a href="#" class="btn">Read more</a></span>
							</p>
						</div>
						<!--div class="col-md-5">
							<img class="feature-image img-responsive" src="images/dhs.jpg"
								alt="${item.company }">
						</div-->
					</div>
				</div>
			</c:forEach>	
            
          </div> 
	   </div>
	</div>
</div>
<!-- //projects -->
		
		
<!--portfolio-->
<div id="portfolio" class="portfolio">
		<div class="container">
			<h3>My Projects</h3>
			<label class="line"></label>
			<div class="sap_tabs">			
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list wow fadeInUp animated" data-wow-delay=".7s" style="display:none;">
						
						<li class="resp-tab-item"><span>All</span></li>
						<c:forEach var="item" items="${form.project }">							
							<li class="resp-tab-item"><span>${item.title }</span></li>
						</c:forEach>	
					</ul>	
					<div class="clearfix"> </div>	
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content">
							<div class="tab_img">
							
								<c:forEach var="item" varStatus="loop" items="${form.project }">
									<div class="col-md-4 portfolio-grids grid tab-margin">
										<div class="effect1 wow fadeInUp animated"
											data-wow-delay="${loop.index % 3 ==0 ? '.5s' : loop.index % 3 == 1 ? '.7s' : '.9s' }">
											<div class="swipebox">
												<img src="data:image/jpg;base64,${item.projectImage }"
													alt="" class="img-responsive" />
												<div class="figcaption">
													<div class="panel_a">
														<h4>${item.title }<span class="font_s">${item.tags }</span>
														</h4>
														<p>${item.intro }</p>
														<p>
															<a class="btn btn-primary" href="${item.link }"
																role="button">Read more</a>
														</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
<!--//portfolio-->

 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal">&times;</button>
				 <h4 class="modal-title">Contrary to popular belief</h4>
			</div>
			<div class="modal-body">
					<img src="images/b1.jpg "alt=" " />
				  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release.</p>
			</div>
			<div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			 </div>
 
		</div>
	</div> 
</div>
     
 <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal">&times;</button>
				 <h4 class="modal-title">The standard chunk</h4>
			</div>
			<div class="modal-body">
					<img src="images/b2.jpg "alt=" " />
				  <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release.</p>
			</div>
			<div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			 </div>
 
		</div>
	</div> 
</div>
<!--contact-->
<div id="contact-form" class="contact">
	<div class="container">
		<h3>Contact</h3>
		<label class="line"></label>
		<div class="col-md-4 c-w3l">
			<i class="fa fa-map-marker" aria-hidden="true"></i>
			<h4>${form.address }</h4>
		</div>
		<div class="col-md-4 c-w3l c-mail">
			<i class="fa fa-envelope" aria-hidden="true"></i>
			<h4><a href="mailto:${form.email}">${form.email }</a></h4>
		</div>
		<div class="col-md-4 c-w3l c-phn">
			<i class="fa fa-phone" aria-hidden="true"></i>
			<h4><a href="tel:${form.phone}">${form.phone }</a></h4>
		</div>
		<div class="clearfix"></div>
		<form action="#" method="post">
			<input type="text" id="contact-name" name="name" class="name" placeholder="Your Name" required="">
			<input type="text" id="contact-email" name="email" class="email" placeholder="Your Email" required="">
			<textarea id="contact-message" name="your message" placeholder="Your Message"  required=""></textarea>
			<input type="submit" id="send-message" value="Send Message">
		</form>
	</div>
</div>
<!--//contact-->


<!--footer-->
<div class="footer-agileinfo">
	<p> &copy; 2016 Copyright: <a href="https://lifetime.photo">profile</a></p>
</div>
<!--//footer-->

<!--common js-->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<!--//common js-->

<!--ResponsiveTabs-->
<script src="${pageContext.request.contextPath }/js/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion           
			width: 'auto', //auto or any width like 600px
			fit: true   // 100% fit in a container
		});
	});		
</script>
<script>
	//send email
	$("#contact-form").on("click", "#send-message", function(click) {
		//first check 		
		var form = $("#contact-form");
		var data = {};
		var name = form.find("#contact-name").val().trim();
		var email = form.find("#contact-email").val().trim();
		//var subject = form.find("#contact-subject").val().trim();
		var message = form.find("#contact-message").val().trim();
		
		if(name=="")
			form.find("#contact-name").addClass("invalid");
		if(email=="")
			form.find("#contact-email").addClass("invalid");
		if(message=="")
			form.find("#contact-message").addClass("invalid");
		if($("#contact-form .invalid").length>0)
			return;
		
		
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
					$("#contact-from input[type='submit']").prop("disabled",true);
				} else {
					console.log(res.errors);
					if(res.errors.name!=undefined)
					{
						$("#contact-form #contact-name").addClass("invalid").attr("title",res.errors.name);
					}
					if(res.errors.email!=undefined)
					{
						$("#contact-form #contact-email").addClass("invalid").attr("title",res.errors.email);
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
<!--//ResponsiveTabs-->
</body>
</html>