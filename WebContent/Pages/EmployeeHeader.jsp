<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="color:#005F8C" href="#"><strong>Employee Maintenance System</strong></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="showSearchEmployee">Search Employee</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="redirectEmployeeHome"><font color="green">
							${userName} </font><span class="glyphicon glyphicon-user"></span> <span
						class="sr-only">(current)</span></a></li>
				<li><a href="logout">Logout<span
						class="glyphicon glyphicon-off"></span></a></li>

			</ul>

		</div>
		<!--/.nav-collapse -->
	</nav>

</body>
</html>