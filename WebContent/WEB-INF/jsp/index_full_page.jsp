<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>My Profile</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">		
		<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrapTheme.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.fullPage.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.carousel.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.theme.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.full.css"  />
	</head>
	<body>
		<div id="header" class="gwidth">
			<ul id="menu" class="nav-box clearfix">
				<li data-menuanchor="page1"><a href="#page1" class="navItem">About</a></li>
				<li data-menuanchor="page2"><a href="#page2" class="navItem">Skills</a></li>
				<li data-menuanchor="page3"><a href="#page3" id="myImg" style="background:url('${form.avatar }') no-repeat 0px 0px"></a></li>
				<li data-menuanchor="page4"><a href="#page4" class="navItem">Education</a></li>
				<li data-menuanchor="page5"><a href="#page5" class="navItem">Experience</a></li>
			</ul>
		</div>
		<div class="header_holder" id="header_holder"></div>
		<div id="fullpage">
			<div class="section section1 active">
				<h1>${form.profession }</h1>
				<div class="wrap">
					<ul class="infor clearfix">
						<li class="data-infor">
							<div class="data-img">
								<div class="data-index">
									<span>Address</span>
								</div>
							</div>
							<div class="data-txt">
		                    	<h1>家庭住址：</h1>
		                    	<p>${form.address }</p>
			                </div>
						</li>
						<li class="data-infor">
							<div class="data-img">
								<div class="data-index">
									<span>Email</span>
								</div>
							</div>
							<div class="data-txt">
		                    	<h1>邮箱：</h1>
		                    	<p><a href="mailto:${form.email }">${form.email }</a></p>
			                </div>
						</li>
						<li class="data-infor">
							<div class="data-img">
								<div class="data-index">
									<span>Tele</span>
								</div>
							</div>
							<div class="data-txt">
		                    	<h1>联系电话：</h1>
		                    	<p><a href="tel:${form.phone }">${form.phone }</a></p>
			                </div>
						</li>
						<li class="data-infor">
							<div class="data-img">
								<div class="data-index">
									<span>Blog</span>
								</div>
							</div>
							<div class="data-txt">
		                    	<h1>技术博客：</h1>
		                    	<p>
		                    		<c:forEach var="item" items="${form.link }">
			                    		<c:if test="${ fn:contains(item.link,'blog') || fn:contains(item.link, 'github')}">
				                    		<a target="_blank" href="${item.link}">
				                    			${item.link }
				                    		</a>
			                    		</c:if>
		                    		</c:forEach>
		                    	</p>
			                </div>
						</li>
					</ul>
				</div>
			</div>
			<div class="section section2">
				<h1>I Can Do!</h1>
				<div class="data-skill">
					<c:set var="colors" value="${fn:split('yell,oran,blue,green',',')}" />
					<ul class="skill-list clearfix">
						<c:forEach var="item" items="${form.skillcategory }">
							<li>
								<div class="list-area area-${colors[random.nextInt(4)] }">${item.title }</div>
								<c:forEach var="sk" items="${form.skill }">
									<c:if test="${sk.scid eq item.id }">
										<p>
											${sk.content}
										</p>
									</c:if>
								</c:forEach>
							</li>
						</c:forEach>						
					</ul>
				</div>
			</div>
			<div class="section section3">
				<div class="container">
				<div class="row">
                 <div class="span12">
                  <h1>My Projects </h1>
				  <div id="owl-example" class="owl-carousel">
				  	<c:forEach var="item" items="${form.project }">
				  		<div class="item" >
				            <a target="_blank" href="${item.link }">
					            <img src="${item.image }" />
					        </a>					        
							<div class="slide-txt">
								<h3>${item.title }</h3>
								<a target="_blank" href="${item.link }">
									<p>${item.intro }</p>
								</a>
							</div>
				        </div>
				  	</c:forEach>
			     </div>
			    </div>
			    </div>
			    </div>
			</div>
			<div class="section section4">
				<c:forEach var="item" items="${form.education }">
					<div class="slide">
					    <h1>Educations</h1>
						<div class="slide-school" >
							<a target="_blank" href="${item.link }">
								<img src="${item.logo }" />
                            </a>
                            <p>School：<span>${item.title }</span></p>
                            <p>Period：<span>${item.period }</span></p>
                            <p>Professional：<span>${item.professional }</span></p>
                            <p>${item.intro }</p>							
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="section section5">
				<h1>My Experience</h1>
				<div class="skin_exprience" >
					<div class="exprience_box" id="exprience_box">
						<div class="mobile_tip" id="mobile_tip">
							Click Transparent Area To Switch
						</div>
						<a href="javascript:;" class="exprience_prev iconfont">&#xe902;</a>
						<a href="javascript:;" class="exprience_next iconfont">&#xe903;</a>
		
						<c:forEach var="item" items="${form.experience}">
							<div class="exprience_text clearfix">
								<div class="u_exprience_head">
									<a target="_blank" href="${item.link }">
										<img src="${item.logo }" alt="${item.company }">									
									</a>
								</div>
								<div class="u_exprience_body">
									<div class="u_exprience_item">
										<a target="_blank" href="${item.link }"><h2>${item.company }</h2></a>
										<p>${item.period }</p>
										<p>${item.position }</p>
										<p>${item.intro }</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>	
		</div>
	
		
		<script src="${pageContext.request.contextPath }/js/jquery.fullPage.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/move.min.js"></script>
	    <script src="${pageContext.request.contextPath }/js/owl.carousel.js"></script>
		<script src="${pageContext.request.contextPath }/js/index.js"></script>
	</body>
</html>