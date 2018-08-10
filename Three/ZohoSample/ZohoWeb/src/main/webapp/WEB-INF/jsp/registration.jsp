
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<a href="?language=en">English</a> | <a href="?language=ch">Chinese</a> | <a href="?language=hi">Hindi</a>


	<h2>Registration JSP</h2>

	<form:form method="POST" action="registration.do"  modelAttribute="UserReg">

		<table border="1">


			<tr>
				<!-- <td>First Name</td> -->
				<td><spring:message code="label.FN" /></td>
				<td>
				
				<form:input path="fname" id="fname"
						placeholder="Please Enter First Name" />
				
				<form:errors path="fname" class="label error-label"></form:errors>		
				</td>

			</tr>


			<tr>

				<!-- <td>Last Name</td> -->
				<td><spring:message code="label.LN" /></td>
				
				
				<td>
				
				<form:input path="lname" id="lname"
						placeholder="Please Enter Last Name" />
						
				<form:errors path="lname" class="label error-label"></form:errors>
						
				</td>

			</tr>

			<tr>

				<!-- <td>Email</td> -->
				<td><spring:message code="label.EMAIL" /></td>
				
				<td>
				
				<form:input path="email" id="email"
						placeholder="Please Enter Email" />
				
				<form:errors path="email" class="label error-label"></form:errors>		
				</td>

			</tr>


			<tr>
				<!-- <td>Password</td> -->
				<td><spring:message code="label.PASSWORD" /></td>

				<td>
				
				<form:password path="password" id="password"
						placeholder="Please Enter Password" />
						
				
				<form:errors path="password" class="label error-label"></form:errors>		
				</td>

			</tr>

			<tr>

				<!-- <td>Mobile no</td> -->
				<td><spring:message code="label.MOBILE" /></td>

				<td>
				
				<form:input path="mobileno" id="mobileno"
						placeholder="Please Enter Mobile no" />
						
				<form:errors path="mobileno" class="label error-label"></form:errors>		
				</td>

			</tr>

			<tr>

				<td colspan="2"><input type="submit" value="Submit"></td>

			</tr>

		</table>

	</form:form>

</body>
</html>