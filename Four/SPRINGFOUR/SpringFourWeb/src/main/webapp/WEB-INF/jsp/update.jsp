<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="employee" action="update" method="POST">
		<table>
		<tr>
			<td><form:input type="hidden" path="id" id="id"/></td>
			
		</tr>		
			<tr>
				<td><label for="firstName">FirstName: </label> </td>
				<td><form:input path="firstName" id="firstName"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="lastName">LastName: </label> </td>
				<td><form:input path="lastName" id="lastName"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		     <tr>
				<td><label for="dept">Department: </label> </td>
				<td><form:input path="dept" id="dept"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		     <tr>
				<td><label for="mobile">Mobile No: </label> </td>
				<td><form:input path="mobile" id="mobile"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
		    
		    <tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input path="address" id="address"/></td>
				<%-- <td><form:errors path="name" cssClass="error"/></td> --%>
		    </tr>
	    
			
		    </table>
							<input type="submit" value="Update"/>
		    </form:form>
		


</body>
</html>