<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
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

<table align="center">
<tr>
<th>User ID</th>
<th>Role</th>
<th>Created Date</th>
<th>Status</th>
</tr>
<% ResultSet rs =(ResultSet) request.getAttribute("rs"); 
	while(rs.next())
	{
%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDate(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%} %>
</table>
<br><br><br>

<%@include file="footer.jsp" %>

</body>
</html>