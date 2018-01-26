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
		response.sendRedirect("../showLogin.do");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<link href="${pageContext.request.contextPath}/Css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/JavaScript.js"></script>
</head>

<body style="padding-top: 70px;">



	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>



	<div class="container">
		<fo:form role="form" action="addEmployee" method="post"
			modelAttribute="empAdd">

			<div class="row">
				<div class="form-group col-md-6">
					First Name
					<fo:input cssClass="form-control" path="firstName"
						pattern="^[a-zA-Z]{3,19}$" required="true" placeholder="eg.abcd"
						oninvalid="setCustomValidity('Please Enter First Name in valid format i.e 3-19 letters')"
						onchange="try{setCustomValidity('')}catch(e){}" />

					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="firstName"></fo:errors> </span>

				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Last Name
					<fo:input cssClass="form-control" path="lastName"
						pattern="^[a-zA-Z]{3,19}$" required="required"
						placeholder="eg.abcd"
						oninvalid="setCustomValidity('Please Enter Last Name in valid format i.e 3-19 letters')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="lastName"></fo:errors> </span>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Date of Birth <input type="date" class="form-control"
						id="txtDateOfBirth" name="dob"
						pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
						required="required"
						oninvalid="setCustomValidity('Please Enter Valid Date i.e age>18yrs and age<58yrs')"
						onchange="try{setCustomValidity('')}catch(e){}" /> <span
						id="dobErr" class="text-danger text-right col-md-12 fade in"><fo:errors
							path="dateOfBirth"></fo:errors> </span>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Date of Joining <input type="date" class="form-control"
						id="txtDateOfJoining" name="doj"
						pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
						required="required"
						oninvalid="setCustomValidity('Please Enter Valid Date of Joining')"
						onchange="try{setCustomValidity('')}catch(e){}" /> <span
						id="dojErr" class="text-danger text-right col-md-12 fade in"><fo:errors
							path="dateOfJoining"></fo:errors> </span>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					DepartMent
					<fo:select cssClass="form-control" path="deptId"
						required="required"
						oninvalid="setCustomValidity('Please select a department')"
						onchange="try{setCustomValidity('')}catch(e){}">
						<c:forEach items="${departments}" var="dept">
							<c:set value="${dept.deptId }" var="deptId"></c:set>
							<c:if test="${deptId == 0 }">
								<fo:option value="">${dept.deptName}</fo:option>
							</c:if>
							<c:if test="${deptId != 0 }">
								<fo:option value="${dept.deptId }">${dept.deptName}</fo:option>
							</c:if>
						</c:forEach>

					</fo:select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Designation
					<fo:select cssClass="form-control" path="designation"
						items="${designation }" required="required"
						oninvalid="setCustomValidity('Please select Designation')"
						onchange="try{setCustomValidity('')}catch(e){}"></fo:select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Basic Salary
					<fo:input cssClass="form-control" path="basic"
						pattern="[8-9][0-9]{3}|[1-9][0-9]{4}" required="required"
						placeholder="eg.8000-100000"
						oninvalid="setCustomValidity('Please Enter Salary in given format i.e 8000-99999')"
						onchange="try{setCustomValidity('')}catch(e){}" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Gender

					<div class="radio-inline">
						<fo:radiobutton cssClass="col-md-3" path="gender" value="M"
							label="Male" checked="checked" />
					</div>
					<div class="radio-inline">
						<fo:radiobutton cssClass="col-md-3" path="gender" value="F"
							label="Female" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-8">
					Marital Status


					<c:forEach items="${maritalStatus}" var="marSt">
						<div class="radio-inline">
							<c:if test="${marSt != '' }">
								<c:if test="${marSt.charAt(0)== 'U' }">
									<fo:radiobutton path="maritalStatus" label="${marSt}"
										value="${marSt.charAt(0) }" checked="checked" />
								</c:if>
								<c:if test="${marSt.charAt(0)!= 'U' }">
									<fo:radiobutton path="maritalStatus" label="${marSt}"
										value="${marSt.charAt(0) }" />
								</c:if>
							</c:if>
						</div>
					</c:forEach>


				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Address
					<fo:input cssClass="form-control" path="address"
						pattern="^[0-9A-Za-z /,/-]{1,10}[a-zA-Z ,]{3,50}$"
						placeholder="eg.abcd, gefh"
						oninvalid="setCustomValidity('Please Enter Valid Address')"
						onchange="try{setCustomValidity('')}catch(e){}" required="required" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="address"></fo:errors> </span>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					Contact number
					<fo:input cssClass="form-control" path="contactNum"
						pattern="[7-9][0-9]{9}" required="required"
						placeholder="10 digit number"
						oninvalid="setCustomValidity('Please Enter Valid Contact Number i.e 10 digit number')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="contactNum"></fo:errors> </span>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<input class="btn btn-primary" type="submit" name="subButton"
						onclick="return validate();" value="Submit" /> <input
						class="btn btn-primary" type="reset" name="clearButton"
						value="Clear" />
				</div>
			</div>
		</fo:form>
		<br>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>