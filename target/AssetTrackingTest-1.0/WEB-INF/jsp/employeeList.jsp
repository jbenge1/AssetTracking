<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
</head>
<body>
	<h1>All Employee Records</h1>
	
	<table>
 			<tr>
				 <td colspan="4"><h1>Person Information</h1></td>
 			</tr>
 			<tr>
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
 				<td>Email Address</td>	
 			</tr>
 			<c:forEach items="${employee}" var="s">
 				<tr>
 					<td>${s.id }</td>
 					<td>${s.firstName}</td>
 					<td>${s.lastName}</td>
 					<td>${s.emailAddr}</td>
 					
 				</tr>
 			</c:forEach>
 		</table>
</body>
</html>