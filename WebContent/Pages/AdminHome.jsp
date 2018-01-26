<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Pragma", 0);
	if (session.getAttribute("userType") == null
			|| !session.getAttribute("userType").equals("Admin")) {
		response.sendRedirect("../showHome");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="padding-top: 70px;">



	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>


	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>
				Welcome <strong class="text-primary">${userName}</strong>
			</h2>
			<img style="margin-top: -73px" class="img-circle" alt=""
				src="Css/${userName}.jpg" align="right" height="86px" width="100px">
		</div>



		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h2>Add Employee!</h2>
				<p>Add employee from here</p>
				<p>
					<a class="btn btn-primary" href="showAddEmployee" role="button">Add
						Employee &raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>View All Employees</h2>
				<p>If you want to see the details of the all employees. You can
					proceed from here !!
				<p>
					<a class="btn btn-primary" href="showViewAll?page=0" role="button">View
						All &raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>Update Employee</h2>
				<p>Has your status changed? Don't worry...!!! You can update the
					details from here as well!</p>
				<p>
					<a class="btn btn-primary" href="showUpdateEmployee" role="button">Update
						&raquo;</a>
				</p>
			</div>
		</div>
	</div>
	<!-- /container -->


	<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>