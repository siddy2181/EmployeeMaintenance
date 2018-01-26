<%@page import="javax.enterprise.context.RequestScoped"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee Management System</title>

<!-- CSS -->
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/form-elements.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/style.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/Css/font-awesome.css"
	rel="stylesheet">

</head>

<body>

	<!-- Content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<!-- <a class="logo" href="index.html"></a> -->
						<h1>
							<strong>Employee</strong> Management System
						</h1>
						<div class="description">
							<p>
								Welcome to IGATE Family,We applaud and appreciate your
								Dedication.<br> Speed Agility Imagination<br> <br>
								<br> <br> <br> <br>
							</p>
						</div>
						<div class="top-big-link">
							<a class="btn btn-link-1 launch-modal"
								data-modal-id="modal-login">Welcome to EMS</a>
						</div>
					</div>
				</div>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br>
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 social-login">
						<div class="social-login-buttons">
							<a class="btn btn-link-2" href="aboutUs"> <i
								class="fa fa-AboutUs"></i> About Us
							</a> <a class="btn btn-link-2" href="History"> <i
								class="fa fa-History"></i> History
							</a> <a class="btn btn-link-2" href="Gallery"> <i
								class="fa fa-Gallery"></i> Gallery
							</a>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>

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

					<fo:form role="form" action="validateLogin" modelAttribute="user"
						class="login-form">
						<div class="form-group">
							<label class="sr-only" for="form-username">Username</label>
							<fo:input path="userName" name="form-username"
								placeholder="Username..." class="form-username form-control"
								id="form-username" required="true" />
						</div>
						<div class="form-group">
							<label class="sr-only" for="form-password">Password</label>
							<fo:password path="password" name="form-password"
								placeholder="Password..." class="form-password form-control"
								id="form-password" required="true" />
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


	<!-- Javascript -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/scripts.js"></script>

	



</body>

</html>