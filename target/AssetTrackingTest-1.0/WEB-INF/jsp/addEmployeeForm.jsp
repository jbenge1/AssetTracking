<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Employee</title>
	</head>
		<h1>Add Employee Form</h1>
		
		<form:form action="addEmployee" method="post" modelAttribute="employee">
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><form:input path="emailAddr"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button>Submit</form:button></td>
				</tr>
				
			</table>
		</form:form>
	<body>

	</body>
</html>