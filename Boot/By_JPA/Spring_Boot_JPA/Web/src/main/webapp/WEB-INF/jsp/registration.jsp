<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Login Page</h2>

 	<form:form method="POST" action="registration" modelAttribute="UserSignUP"> 
	
		
		<table border="1">

			<tr>
			<td><form:input type="hidden" path="id" id="id"/></td>
			
			</tr>

			<tr>
				<td>First Name</td>

				<td><form:input path="fname" id="fname"
						placeholder="Please Enter First Name" />
				</td>

			</tr>

			<tr>
				<td>Last Name</td>

				<td><form:input path="lname" id="lname"
						placeholder="Please Enter Last Name" />
				</td>

			</tr>


			<tr>

				<td>Email</td>

				<td><form:input path="email" id="email"
						placeholder="Please Enter Email" />
				</td>

			</tr>


			<tr>
				<td>Password</td>

				<td><form:password path="password" id="password"
						placeholder="Please Enter Password" />
				</td>

			</tr>


			<tr>
				<td>Mobile</td>

				<td><form:input path="mobile" id="mobile"
						placeholder="Please Enter Mobile no" />
				</td>

			</tr>



			<tr>

				<td><input type="submit" value="login"></td>
				
				<td><a href="<c:url value='/list' />">List of All User</a></td>
			
			</tr>

		

		</table>



	</form:form>



</body>
</html>