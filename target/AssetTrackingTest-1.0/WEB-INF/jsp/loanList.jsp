<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan List</title>
</head>
<body>
	<h1>All Loan Records</h1>
	
	<table>
 			<tr>
				 <td colspan="5"><h1>Person Information</h1></td>
 			</tr>
 			<tr>
				<td>ID</td>
				<td>Employee ID</td>
				<td>Employee Name</td>
				<td>Asset ID</td>
 				<td>Start Date</td>
 				<td>End Date</td>	
 			</tr>
 			<c:forEach items="${loan}" var="s">
 				<tr>
 					<td>${s.id }</td>
 					<td>${s.employeeID}</td>
 					<td>${s.employeeName}</td>
 					<td>${s.assetID}</td>
 					<td>${s.startDate}</td>
 					<td>${s.endDate}</td> 					
 				</tr>
 			</c:forEach>
 		</table>
</body>
</html>