<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo"%>
<!DOCTYPE html >
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
<body style="padding-top: 70px;">


	<jsp:include page="EmployeeHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>





	<div class="container">
		<fo:form action="searchEmployee" method="post"
			modelAttribute="empSearch">


			<div class="row">
				<div class="form-group col-md-6">
					Employee Id
					<fo:input cssClass="form-control" path="empId" pattern="[0-9 /* /?]{0,6}" placeholder="6 digit number"/>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					First Name
					<fo:input cssClass="form-control" path="firstName" pattern="[a-zA-Z /* /?]{0,19}" placeholder="eg.abc"/>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Last Name
					<fo:input cssClass="form-control" path="lastName" pattern="[a-zA-Z /* /?]{0,19}" placeholder="eg.abc"/>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					DepartMent
					<fo:select cssClass="form-control" path="deptId">
						<c:forEach items="${departments }" var="dept">
							<fo:option label="${dept.deptName }" value="${dept.deptId }" />
						</c:forEach>
					</fo:select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Grade
					<fo:select cssClass="form-control" path="grade">
						<div class="form-group col-md-4">
							<c:forEach items="${grades}" var="grade">
								<fo:option value="${grade.gradeCode }">${grade.description}</fo:option>
							</c:forEach>
						</div>
					</fo:select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Marital Status
					<fo:select cssClass="form-control" path="maritalStatus">

						<c:forEach items="${maritalStatus }" var="marSt">
							<c:if test="${marSt != '' }">
								<fo:option value="${marSt.charAt(0) }" label="${marSt}"></fo:option>
							</c:if>
							<c:if test="${marSt == '' }">
								<fo:option value="${marSt}" label="${marSt}"></fo:option>
							</c:if>
						</c:forEach>
					</fo:select>

					<div class="form-group col-md-4"></div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					<button class="btn btn-primary" type="submit" name="subButton"
						value="Search"><span class="glyphicon glyphicon-search"></span>  Search</button>
				</div>
			</div>

		</fo:form>

		<br>
		<c:if test="${errorMsg!=null }">
			<div class="alert alert-danger fade in">${errorMsg}</div>
		</c:if>
	</div>



	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>