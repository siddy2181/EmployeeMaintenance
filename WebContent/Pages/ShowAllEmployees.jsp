<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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
<title>Show All Employees</title>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="padding-top: 70px;">
	

	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>

	<div style="padding: 50px;">
		<table class="table table-striped">
			<tr style="color: #530029">
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
			<c:forEach items="${EmployeeList}" var="list">
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

		<br> <br>
		<c:set value="${nextPage}" var="next"></c:set>
		<c:set value="${prePage}" var="pre"></c:set>
		<c:set value="${curPage}" var="cur"></c:set>
		<c:set value="${lastPage}" var="last"></c:set>

		<ul class="pager">

			<li <c:if test="${cur==0}">class="disabled"</c:if>><a
				<c:if test="${cur==0}">href="#"</c:if>
				<c:if test="${cur!=0}">href="showViewAll?page=0"</c:if>>First</a></li>
			<li <c:if test="${cur==0}">class="disabled"</c:if>><a
				<c:if test="${cur==0}">href="#"</c:if>
				<c:if test="${cur!=0}">href="showViewAll?page=${pre}"</c:if>>Previous</a></li>
			<li <c:if test="${cur==last}">class="disabled"</c:if>><a
				<c:if test="${cur==last}">href="#"</c:if>
				<c:if test="${cur!=last}">href="showViewAll?page=${next}"</c:if>>next</a></li>
			<li <c:if test="${cur==last}">class="disabled"</c:if>><a
				<c:if test="${cur==last}">href="#"</c:if>
				<c:if test="${cur!=last}">href="showViewAll?page=${lastPage}"</c:if>>Last</a></li>
		</ul>
	</div>

	

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>