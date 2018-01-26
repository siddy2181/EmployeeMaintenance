
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spr"%>
<!DOCTYPE html>
<html>
<head>


<link href="<c:url value="/Css/design.css"></c:url>" rel="stylesheet">

<link href="<c:url value="/Css/bootstrap.min.css"></c:url>"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/sticky-footer.css"
	rel="stylesheet">

<meta name="viewport" content="width=device-width,intial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="jumbotron" align="center">
		<h1>Employee Maintenance System</h1>
		<!-- <img class="i1" src="Css/IGate-logo.png" align="right"> -->
	</div>



	<!-- <h2 class="title">Employee Maintenance System</h2> -->
	<hr>

	<div class="d2">
		<img class="d22,img-responsive" src="Css/img.png">
		<div class="container">
			<a href="showLogin">Login</a>
		</div>
	</div>



	
	<jsp:include page="Footer.jsp"></jsp:include>




</body>
</html>