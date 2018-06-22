<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asset List</title>
</head>
<body>
	<h1>All Asset Records</h1>
	
	<table>
 			<tr>
				 <td colspan="5"><h1>Asset Information</h1></td>
 			</tr>
 			<tr>
				<td>ID</td>
				<td>Serial Number</td>
				<td>Vendor</td>
 				<td>Date</td>
 				<td>Notes</td>	
 			</tr>
 			<c:forEach items="${asset}" var="s">
 				<tr>
 					<td>${s.id }</td>
 					<td>${s.serialNumber}</td>
 					<td>${s.vendor}</td>
 					<td>${s.disposalDate}</td>
 					<td>${s.notes}</td>
 					
 				</tr>
 			</c:forEach>
 		</table>
</body>
</html>