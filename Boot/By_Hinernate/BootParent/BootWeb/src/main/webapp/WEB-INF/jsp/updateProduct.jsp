<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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


	<h2>Product JSP</h2>

	<form:form method="POST" action="updateProduct" modelAttribute="UserProduct" >

		<table border="1" align="center">

			<tr>
			
			<td><form:input type="hidden" path="pid" id="pid"/></td>

			</tr>
			
			<tr>
				<td>Product Name</td>

				<td><form:input path="pname" id="pname"
						placeholder="Please Enter Product Name" /> 
				</td>

			</tr>

			<tr>
				<td>Product Description</td>

				<td><form:input path="pdescription" id="pdescription"
						placeholder="Please Enter Product Description" /> 
						
				</td>

			</tr>

			<tr>
				<td>Product Price</td>

				<td><form:input path="pprice" id="pprice"
						placeholder="Please Enter Product Price" /> 
				</td>

			</tr>

			<tr>
				<td>Product Quantity</td>

				<td><form:input path="pquantity" id="pquantity"
						placeholder="Please Enter Product Quantity" /> 
				</td>

			</tr>



			<tr>

				<td colspan="2"><input type="submit" value="Update"></td>
			
			</tr>


		</table>


	</form:form>



</body>
</html>