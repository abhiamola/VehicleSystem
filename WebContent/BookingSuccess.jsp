<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body bgcolor="cdb79e">




<%@ include file="header.jsp" %>
<%@include file="header1.jsp" %>
</br>

<h3><b>Congrats Your Booking request has been Marked Kindly wait till Confirmation</b> </h3>

<h4><b>Details:</b></h4>
</br>

<%ArrayList book = (ArrayList) request.getAttribute("booking"); %>
<div align="center">
<table border="1" class="table">
<tr>
<td><b>Vehicle ID</b></td>
<td><b>Manufacturer;s Name</b></td>
<td><b>EX ShowRoom Price</b></td>
<td><b>Color</b></td>
<td><b>Booking Status</b></td>
<td><b>Booking Confirmed Date</b></td>
<td><b>Branch</b></td>
<td><b>Comments</b></td>
</tr>
<tr>
<% for(int i=0;i<book.size();i++)
	{%>

<td><%=book.get(i) %></td>


<%} %>

</tr>
</table>
</div>
</br>


<a href ="Search_Page.jsp">Book Another Vehicle</a>
<br>


<%@include file="footer.jsp" %>






</body>
</html>