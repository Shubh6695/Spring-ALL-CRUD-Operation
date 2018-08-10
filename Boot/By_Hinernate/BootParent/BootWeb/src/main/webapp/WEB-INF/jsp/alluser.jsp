
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#MYTABLE').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>




</head>
<body>

	<center>
		<h4>All User List</h4>
	
	</center>	


<table id="MYTABLE" border="1" align="center">


		<thead>
			<tr>

				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Mobile</td>
				
			</tr>
		</thead>


		<tbody>
			<c:choose>

				<c:when test="${empty userList}">
				<tr>
				
				<td align="center" colspan="5">	
			
					No Record Found.
				</td>		
				
				</tr>
			</c:when>

				<c:otherwise>

					<c:forEach items="${userList}" var="ulist">

						<tr>
							<td><c:out value="${ulist.id}"></c:out></td>
							<td><c:out value="${ulist.fname}"></c:out></td>
							<td><c:out value="${ulist.lname}"></c:out></td>
							<td><c:out value="${ulist.email}"></c:out></td>
<%-- 
							<td><c:out value="${ulist.password}"></c:out></td>
 --%>
							
							<td><c:out value="${ulist.mobile}"></c:out></td>
							<td><a href="<c:url value='/edit-${ulist.id}'/>">edit</a></td>
							<td><a href="<c:url value='/delete-${ulist.id}'/>">delete</a></td>	
								
				

						</tr>

					</c:forEach>

				</c:otherwise>

			</c:choose>

		</tbody>

</table>

<a href="registration">Add User</a>


</body>
</html>