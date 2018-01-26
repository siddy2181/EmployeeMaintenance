<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- CSS -->
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/form-elements.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/font-awesome.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/theme.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/carousel.css"
	rel="stylesheet">


</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1 class="home">
				<strong>Employee</strong> Maintenance System
			</h1>
		</div>


		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="first-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>Employee Maintenance System URL, the "next" and "previous"
								Glyphicon buttons on the left and right might not load/display
								properly due to web browser security rules.</p>

							<!-- <div class="top-big-link"> -->
							<p>
								<a class="btn btn-lg btn-primary launch-modal" 
									data-modal-id="modal-login">Welcome to EMS</a>
							</p>


						</div>
					</div>
				</div>
				<div class="item">
					<img class="second-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>IGATE Corporation, 
							today announced that Indo-American Chamber of Commerce (IACC) has 
							honored and awarded IGATE for Excellence in Innovation (US Company)</p>
							<p>
								<a class="btn btn-lg btn-primary" href="Gallery" role="button">Gallery</a>
								<!-- <a class="btn btn-link-2" href="Gallery"> <i class="fa fa-Gallery"></i>
								Gallery
							</a> -->
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>Capgemini completes the acquisition of US-based IGATE Corporation - July 1, 2015: 
							Capgemini, today announced that it has completed the acquisition of IGATE Corporation.
							 The transaction is expected to be accretive to Capgemini normalized Earnings Per Share (EPS)
							  by at least 12% in 2016 and 16% in 2017.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="aboutUs" role="button"> About Us</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->

		<!-- MODAL -->
		<div class="modal fade" id="modal-login" tabindex="-1" role="dialog"
			aria-labelledby="modal-login-label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h3 class="modal-title" id="modal-login-label">Login to our
							site</h3>
						<p>Enter your username and password to log on:</p>
					</div>

					<div class="modal-body">

						<fo:form id="loginForm" role="form" action="validateLogin"
							modelAttribute="user" class="login-form">
							<div class="form-group">
								<label class="sr-only" for="form-username">Username</label>
								<fo:input path="userName" name="form-username"
									placeholder="Username..." class="form-username form-control"
									id="form-username" />
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-password">Password</label>
								<fo:password path="password" name="form-password"
									placeholder="Password..." class="form-password form-control"
									id="form-password" />
							</div>
							<button type="submit" class="btn" name="btnSubmit" value="Login">Sign
								in!</button>

							<c:set var="error" value="${errorMsg }"></c:set>
							<c:if test="${error!=null}">
								<div class="row">
									<div class="text-danger fade in col-md-6">${errorMsg}</div>
								</div>
							</c:if>
						</fo:form>

					</div>

				</div>
			</div>
		</div>












	</div>

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/carousel.js"></script>
	<script src="js/holder.js"></script>

<%-- 	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></c:url>"></script> --%>

<%-- 	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/holder.js"></c:url>"></script> --%>

<%-- 	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/carousel.js"></c:url>"></script> --%>

<!-- 	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/carousel.js"></script>
	<script src="js/holder.js"></script> -->

<%-- 	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></c:url>"></script>

	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/holder.js"></c:url>"></script>

	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/carousel.js"></c:url>"></script> --%>

</body>
</html>