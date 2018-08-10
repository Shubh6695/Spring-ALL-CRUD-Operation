
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello</h2>

	<!-- Step no:- 7(a) Create a link -->

	<a href="login.do">Please Click here for Login</a>

	</br>

	<a href="registration.do">Please Click here for Registration</a>

</body>
</html> --%>



<%
response.sendRedirect("login.do");

%>


