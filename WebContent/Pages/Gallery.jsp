<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/theme.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/Css/carousel.css"
	rel="stylesheet">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<div class="page-header">
			<h1>Employee Maintenance System</h1>
		</div>
		

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="first-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>
								Employee Maintenance System
								 At a time when the technology landscape is changing dramatically,
								  we believe that these three attributes will be the key guiding principles 
								  for us to navigate our way to higher value for all our stake holders.
							</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Sign
									up today</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="second-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>IGATE is a global leader in providing integrated technology and operations-based solutions, 
								headquartered in Bridgewater, New Jersey. As a trusted partner to corporations in North America, 
							 	Europe and Asia Pacific, IGATE provides solutions to clients'
							 	business challenges by leveraging its technology and process capabilities,
							  	underwritten by an understanding of domain and industry imperatives.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Learn
									more</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide"
						src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Welcome to IGATE</h1>
							<p>Capgemini completes the acquisition of US-based IGATE Corporation - July 1, 2015: 
							Capgemini, today announced that it has completed the acquisition of IGATE Corporation.
							 The transaction is expected to be accretive to Capgemini normalized Earnings Per Share (EPS)
							  by at least 12% in 2016 and 16% in 2017.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Browse
									gallery</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->












	</div>

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/carousel.js"></script>
	<script src="js/holder.js"></script>

	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></c:url>"></script>

	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/holder.js"></c:url>"></script>

	<script type="text/javascript"
		src="<c:url value="${pageContext.request.contextPath}/js/carousel.js"></c:url>"></script>

</body>
</html>