<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Registration Form</h2>
 
	<form:form modelAttribute="employee" action="registration" method="POST">
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
		    					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
		    </form:form>
		    
		    Go back to <a href="<c:url value='/list' />">List of All Employees</a>
		    
</body>
</html>