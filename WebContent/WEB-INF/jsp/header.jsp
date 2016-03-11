<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/mdb.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/icon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">

<nav class="double-navbar navbar navbar-fixed-top pt-color z-depth-1"
	role="navigation">
	<div class="container-fluid">
		<div class="navbar-header pull-left">
           <!-- SideNav slide-out button -->
           <a href="#" data-activates="slide-out" class="button-collapse hidden-lg hidden-md"><i class="fa fa-bars"></i></a>
     	</div>
     	
     	<ul class="list-inline pull-right text-center">
     		<li><a href="#" data-toggle="modal" data-target="#contact-form" class="waves-effect waves-light"><i class="fa fa-envelope-o"></i><br><span>Contact</span></a></li>
     	
     	</ul>
	</div>
	
	<!-- Modal: Contact form -->
        <div class="modal fade" id="contact-form" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                    	<button type="button" class="close" data-dismiss="modal">×</button>
                        <h4 class="modal-title text-center col-md-11">Write To Me </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form class="col-md-12">
                                <p>I like to receive a messages</p>
                                <br>
                                <div class="input-field">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="contact-name" type="text" class="validate" required="required">
                                    <label for="contact-name" data-error="wrong" data-success="right">Your name</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix">mail</i>
                                    <input id="contact-mail" type="text" class="validate" required="required">
                                    <label for="contact-mail" data-error="wrong" data-success="right">Your e-mail</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix">label</i>
                                    <input id="contact-subject" type="text" class="validate" required="required">
                                    <label for="contact-subject" data-error="wrong" data-success="right">Subject</label>
                                </div>
                                <div class="input-field">
                                    <i class="material-icons prefix">mode_edit</i>
                                    <textarea id="contact-text" class="materialize-textarea"></textarea>
                                    <label for="contact-text">Message</label>
                                </div>
                            </form>
                            <div class="text-center">
                                <button type="button" class="send btn btn-primary waves-effect waves-light">Send</button>
                            </div>
                            <!--div class="col-md-12">
                                <div class="call">
                                    <p>Or would you prefer to call? <span class="cf-phone"><i class="fa fa-phone"> +01 234 565 280</i></span></p>
                                </div>
                            </div-->
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--/.Modal: Contact form-->
</nav>
