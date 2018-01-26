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
<title>Employee Updation</title>
</head>
<body style="padding-top: 70px;">



	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="${userName }" name="userName" /></jsp:include>

	<div class="container">
		<fo:form action="UpdateEmployee" method="post"
			modelAttribute="empUpdate">


			<div class="row">
				<div class="form-group col-md-6">
					Employee Id:
					<fo:hidden cssClass="form-control" path="empId" />
					<span class="text-primary"><strong>${empUpdate.empId }</strong></span>

				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					First Name:
					<fo:hidden cssClass="form-control" path="firstName" />
					<span class="text-primary"><strong>${empUpdate.firstName }</strong></span>

				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					Last Name:
					<fo:input cssClass="form-control" path="lastName"
						pattern="^[a-zA-Z]{3,19}$" required="required"
						oninvalid="setCustomValidity('Please Enter Last Name in valid format i.e 3-19 letters')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="firstName"></fo:errors> </span>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					Department
					<fo:select cssClass="form-control" path="deptId"
						required="required"
						oninvalid="setCustomValidity('Please select a department')"
						onchange="try{setCustomValidity('')}catch(e){}">
						<div class="form-group col-md-4">
							<c:forEach items="${departments }" var="dept">
								<c:set value="${dept.deptId }" var="deptId"></c:set>
								<c:if test="${deptId == 0 }">
									<fo:option value="">${dept.deptName}</fo:option>
								</c:if>
								<c:if test="${deptId != 0 }">
									<fo:option value="${dept.deptId }">${dept.deptName}</fo:option>
								</c:if>
							</c:forEach>
						</div>
					</fo:select>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Designation:
					<fo:select cssClass="form-control" path="designation"
						items="${designation}" required="required"
						oninvalid="setCustomValidity('Please select Designation')"
						onchange="try{setCustomValidity('')}catch(e){}">
						<div class="form-group col-md-4"></div>
					</fo:select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					Basic Salary:
					<fo:input cssClass="form-control" path="basic"
						pattern="[8-9][0-9]{3}|[1-9][0-9]{4}" required="required"
						oninvalid="setCustomValidity('Please Enter Salary in given format i.e 8000-999999')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<div class="form-group col-md-4"></div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-8">
					Marital Status:
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
					Home Address:
					<fo:input cssClass="form-control" path="address"
						pattern="[0-9A-Za-z /,/-]{0,10}[a-zA-Z ,]+" required="required"
						oninvalid="setCustomValidity('Please Enter Valid Address')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="address"></fo:errors> </span>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-6">
					Personal Contact Number
					<fo:input cssClass="form-control" path="contactNum"
						pattern="[7-9][0-9]{9}" required="required"
						oninvalid="setCustomValidity('Please Enter Valid Contact Number i.e 10 digit number')"
						onchange="try{setCustomValidity('')}catch(e){}" />
					<span class="text-danger text-right col-md-12 fade in"><fo:errors
							path="contactNum"></fo:errors> </span>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<input class="btn btn-primary" type="submit" name="subButton"
						value="Update" />
				</div>
			</div>
		</fo:form>

		<c:set value="${updated}" var="upd"></c:set>
		<c:if test="${upd == 1 }">
			<div class="alert alert-success fade in">
				Details of <strong>${empUpdate.firstName}</strong> Is Updated.!
			</div>
			<table class="table table-striped">
				<tr style="color: #530029">
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>

					<th>Department Id</th>
					<th>Grade</th>
					<th>Designation</th>
					<th>Basic Salary</th>

					<th>Marital Status</th>
					<th>Residence Address</th>
					<th>Contact Number</th>
				</tr>

				<tr>
					<td>${empUpdate.empId}</td>
					<td>${empUpdate.firstName}</td>
					<td>${empUpdate.lastName}</td>

					<td>${empUpdate.deptId}</td>
					<td>${empUpdate.grade}</td>
					<td>${empUpdate.designation}</td>
					<td>${empUpdate.basic}</td>

					<td>${empUpdate.maritalStatus}</td>
					<td>${empUpdate.address}</td>
					<td>${empUpdate.contactNum}</td>
				</tr>

			</table>
		</c:if>

	</div>



	<jsp:include page="Footer.jsp"></jsp:include>



</body>
</html>