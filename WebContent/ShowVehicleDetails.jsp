
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.catp.model.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="header.jsp" %><br>
<h1 align="center">Vehicle Details</h1><br>
<% ArrayList<Booking> al2 = new ArrayList<Booking>();
al2 = (ArrayList<Booking>)request.getAttribute("bookingob"); %>

<h1 align="center">For further Request select vehicle code</h1><br>
<div align="center">
<table border="1" class="table">
<tr>
<td> <b>Vehicles Code</b></td>
<td> <b> No of vehicles available in stock</b></td>
</tr>

<%  for(Booking c:al2){ %>
<tr>
<td align="center"><form action="RetVehicleReqController" method="post"><input type="submit" class="button" name ="vehcode" value="<%=c.getVehicleCode() %>"></form></td>
<td align="center"><%=c.getStockNo() %></td>

<% } %>
</table></div><br> 
<div align="center"><form action = "BAdminHome.jsp"><input type="submit" class="button" value="Go Back To Booking Requests"></form></div>
<br><br><%@include file="footer.jsp" %>
</body>
</html>