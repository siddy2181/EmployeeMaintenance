<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo"%>
<!DOCTYPE html>
<html>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Pragma", 0);
	if (session.getAttribute("userType") == null
			|| !session.getAttribute("userType").equals("Admin")) {
		response.sendRedirect("../showLogin");
	}
%>
<head>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-top: 70px;">
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>

	<div class="container">

		<div class="alert alert-success" role="alert">
			<div class="row">
				<div class="form-group col-md-6">
					Employee Id: <strong>${inserted.empId}</strong>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					First Name: <strong>${inserted.firstName}</strong>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Last Name: <strong>${inserted.lastName}</strong>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Home Address: <strong>${inserted.address}</strong>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Contact Number: <strong>${inserted.contactNum}</strong>

				</div>
			</div>



		</div>

		<%-- ID--------${inserted.empId} FirstName--------${inserted.firstName} --%>
	</div>

	<nav class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container-fluid" align="center">
			Welcome to IGATE Family,We applaud and appreciate your Dedication.<br>
			Speed Agility Imagination
		</div>
	</nav>
</body>
</html>