<%@page import="com.catp.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Style/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="Script/Myscript.js"></script>
</head>
<body>
<%@include file="header.jsp" %><br>
<%@include file="header1.jsp" %>
<h1 align="center">Vehicle Request Generator</h1><br>
<br><br><br>
<form action="FinalReqController" method="post">
<% Booking c= (Booking)session.getAttribute("vehicleob"); %>
<div align="center">
<table border="1" class="table">
<tr> <td align="center"> <b>Vehicle Id</b></td>
<td align="center"><%=c.getVehicleCode() %></td></tr>
<tr><td align="center"> <b> Branch</b></td>
<td align="center"><%=c.getBranch() %></td></tr>
<tr><td align="center"> <b>Color </b></td>
<td align="center"><%=c.getColor() %></td></tr>

<tr><td align="center"> <b> No. of Vehicles to request</b></td>
<td align="center"><input type="text" id ="numberreq" name="numberreq"></td></tr>

</table></div>
<br>
<p align="center" id="cPartMsg"></p>
<% session.setAttribute("vehicleob",c);  %>
<br><br><br>
<div align="center"><input type="submit" name ="vehcode" onClick = "return validate();" value="Submit Request"></div></form><br>
<div align="center"><form action = "BAdminHome.jsp"><input type="submit" class="button" value="Go Back To Booking Requests"></form></div>
<br><br><%@include file="footer.jsp" %></body>
</html>

