<%@page import="com.catp.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Style/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file="header.jsp" %>
<%@include file="header1.jsp" %><br>
<h1 align="center">Vehicle Details</h1><br>
<% Booking c= (Booking)request.getAttribute("vehicleob"); %>
<div align="center">
<table border="1" class="table">
<tr align="center"> <td> <b>Vehicle Id</b></td>
<td align="center"> <b>Manufacture Name </b></td>
<td align="center"> <b> ExShowroom Price</b></td>
<td align="center"><b> Colour</b></td>
<td align="center"> <b> No. of vehicles in Stock</b></td>
<td align="center"> <b> Branch</b></td>
</tr>
<tr>
<td align="center"><%=c.getVehicleCode() %></td>
<td align="center"><%=c.getManufactureName() %></td>
<td align="center"><%=c.getExShowroomPrice() %></td>
<td align="center"><%=c.getColor() %></td>
<td align="center"><%=c.getStockNo() %></td>
<td align="center"><%=c.getBranch() %></td>
</table></div>
<br><br><br>
<% session.setAttribute("vehicleob",c);  %><div align="center">
<form action="ReqGenerate.jsp"><input type="submit" class="button" name ="vehcode" value="Request"></form></div><br>
<div align="center"><form action = "BAdminHome.jsp"><input type="submit" class="button" value="Go Back To Booking Requests"></form></div>
<br><br><%@include file="footer.jsp" %>
</body>
</html>

