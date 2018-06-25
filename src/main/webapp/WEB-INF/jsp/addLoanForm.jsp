<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Loan</title>
	</head>
	
	<body>
		<h1>Add Loan Form</h1>
		<div>
		<a href="/">Home</a>
		</div>
		<form:form action="addLoan" method="post" modelAttribute="loan" >
			<table>
				<tr>
					<td>Employee ID</td>
					<td><form:input path="employeeID"/></td>
				</tr>
				<tr>
					<td>Asset ID</td>
					<td><form:input path="assetID"/></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="startDate" value="YYYY-MM-DD"/></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><form:input path="endDate" value='1992-10-25'/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button>Submit</form:button></td>
				</tr>
			</table>
		</form:form>
		<div>
			*Note: If there is no end date, leave 1992-10-25, otherwise change this.
		</div>
	</body>
</html>