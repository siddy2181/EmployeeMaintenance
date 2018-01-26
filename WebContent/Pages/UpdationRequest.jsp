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
		response.sendRedirect("../showHome");
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

		<fo:form role="form" action="UpdateRequest" method="post">
			<div class="row">
				<div class="form-group col-md-6">
					Employee Id: <select class="form-control" name="selEmpId">
						<c:forEach items="${empIds }" var="empId">
							<option value="${empId }">${empId }</option>
						</c:forEach>
					</select>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					<input class="btn btn-primary" type="submit" name="btmUpdate"
						value="Update" />
				</div>
			</div>
		</fo:form>
	</div>





	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>