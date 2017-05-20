<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.catp.model.BookingVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body bgcolor="cdb79e">
<%
ArrayList<BookingVO> allbook = new ArrayList<BookingVO>();

allbook = (ArrayList)request.getAttribute("allbooking");
BookingVO bvo = new BookingVO();
%>

<%@ include file="header.jsp" %>
<%@include file="header1.jsp" %>

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

<%for(BookingVO bv : allbook)
{
	%>
<tr>
<td><%=bv.getVehicle_id() %></td>
<td><%=bv.getManufacturer_name() %></td>
<td><%=bv.getExprice() %></td>
<td><%=bv.getColor() %></td>
<td><%=bv.getStatus() %></td>
<td><%=bv.getBookingconfirmdate() %></td>
<td><%=bv.getBranch_location() %></td>
<td><%=bv.getComments() %></td>

</tr>
<%} %>
</table>
</div>
</br>
<a href="Search_Page.jsp">Book Another Vehicle</a>
<br>
</body>
</html>