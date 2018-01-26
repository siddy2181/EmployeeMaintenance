
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Pragma", 0);
	if (session.getAttribute("userType") == null
			|| !session.getAttribute("userType").equals("Employee")) {
		response.sendRedirect("../showHome");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="padding-top: 70px;">

	
	
	<jsp:include page="EmployeeHeader.jsp"> <jsp:param value="${userName }" name="userName"/></jsp:include>


	<div class="container">
		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>Welcome <strong class="text-primary">${userName}</strong></h2>
			<img style="margin-top: -73px" class="img-circle" alt="" src="Css/${userName}.jpg" align="right" height="86px" width="100px">
		</div>



		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h2>Search Employee!</h2>
				<p>Search Employee Directory from System</p>
				<p>
					<a class="btn btn-primary" href="showSearchEmployee" role="button">Search
						Employee &raquo;</a>
				</p>
			</div>

		</div>
	</div>
	<!-- /container -->

	
	
	<jsp:include page="Footer.jsp"></jsp:include>




</body>
</html>



