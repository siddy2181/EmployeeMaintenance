<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Search Employee</title>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="SearchEmployee.jsp"></jsp:include>
<div style="padding: 50px;">
	<table class="table table-striped table-hover">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date Of Birth</th>
			<th>Date Of Joining</th>
			<th>Department Id</th>
			<th>Grade</th>
			<th>Designation</th>
			<th>Basic Salary</th>
			<th>Gender</th>
			<th>Marital Status</th>
			<th>Residence Address</th>
			<th>Contact Number</th>
		</tr>
		<c:forEach items="${emps}" var="list">
			<tr>
				<td>${list.empId}</td>
				<td>${list.firstName}</td>
				<td>${list.lastName}</td>
				<td>${list.dateOfBirth}</td>
				<td>${list.dateOfJoining}</td>
				<td>${list.deptId}</td>
				<td>${list.grade}</td>
				<td>${list.designation}</td>
				<td>${list.basic}</td>
				<td>${list.gender}</td>
				<td>${list.maritalStatus}</td>
				<td>${list.address}</td>
				<td>${list.contactNum}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>