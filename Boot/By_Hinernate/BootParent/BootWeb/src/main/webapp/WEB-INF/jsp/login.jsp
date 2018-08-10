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



	<h2>Login JSP</h2>

	<form:form method="POST" action="login"  modelAttribute="UserLogin">

		<table border="1" align="center">

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

				<td colspan="2"><input type="submit" value="login">

				<a href="registration">Click for Registration</a></td>
					
			</tr>

		</table>
		
		
		<!-- <a href="product">Click for Product</a> -->

	</form:form>


</body>
</html>