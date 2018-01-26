<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link type="text/css" rel="stylesheet" href="Css/design.css" />
</head>
<body>
	<%
		String errorMsg = request.getAttribute("errorMsg").toString();		

		if (errorMsg.equals("InvalidUser")) {
			errorMsg = "Invalid UserName or Password";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/Pages/login.jsp");
			rd.forward(request, response);
		}
		if (errorMsg.equals("NoData")) {
			errorMsg = "No employee Found...Pls Enter valid details";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/Pages/SearchEmployee.jsp");
			rd.forward(request, response);
		}
	%>
<h3>${errorMsg}</h3>
</body>
</html>