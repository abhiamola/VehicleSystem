<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<br><br><br>
<a href="AccountApprovalController">Approve Pending Registrations</a>
<br><br><br>
View Status by following options
<br><br>
<form name="myForm" action="AccountApprovalController" method="post">
<div align="center">
<table align="center">
<tr>
<td>Role </td>
<td>: 
<select name="uRole">
<option value="Customer">Customer</option>
<option value="Branch Admin">Branch Admin</option>
</select>
</td>
<td>Sorted By </td>
<td>: 
<select name="sort">
<option value="created_date">Created Date</option>
<option value="status">Status</option>
<option value="role">Role</option>
</select>
</td>
<td><input type="submit" value="Submit"/></td>
</tr>
</table>
</div>
</form>
<br>
<form name="myForm1" action="AccountApprovalController" method="post">
<div align="center">
<table align="center">
<tr>
<td>Status </td>
<td>: 
<select name="stat">
<option value="Pending">Pending</option>
<option value="Approve">Approve</option>
<option value="Reject">Reject</option>
</select>
</td>
<td>Sorted By </td>
<td>: 
<select name="sort">
<option value="created_date">Created Date</option>
<option value="status">Status</option>
<option value="role">Role</option>
</select>
</td>
<td><input type="submit" value="Submit"/></td>
</tr>
</table>
</div>
</form>
<br><br><br>

<%@include file="footer.jsp" %>
</body>
</html>