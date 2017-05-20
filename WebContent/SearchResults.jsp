<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.catp.model.BookingVO" %>
    <%@page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search_Results</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body bgcolor="cdb79e">
<%
ArrayList<BookingVO> vehicle = new ArrayList<BookingVO>();

vehicle = (ArrayList)request.getAttribute("searchob");
BookingVO bvo = new BookingVO();
%>

<%@ include file="header.jsp" %>
<%@include file="header1.jsp" %>

<form name ="result_form" method="post" action ="BookingController">
<p name="userName" value="<%=bvo.getUser_id() %>"></p>
<br>
<br>

<div align = "center">
<table border="1" class="table">
<tr>
<td><b>Manufacturer_name</b></td>
<td><b>ExShowroomPrice</b></td>
<td><b>Color</b></td>
<td><b>Seating Capacity</b></td>
<td><b>Branch Location</b></td>
<td><b>Vehicle_code</b></td>
<td><b># of Vehicles available</b></td>
<td><b>Stock Lasts till</b></td>
<td><b>Confirm Booking</b></td>




<%for(BookingVO bv : vehicle)
{
	%>
<tr>
<td><%=bv.getManufacturer_name() %></td>
<td><%=bv.getExprice() %></td>
<td><%=bv.getColor() %></td>
<td><%=bv.getSeating() %></td>
<td><%=bv.getBranch_location() %></td>
<td><%=bv.getVehicle_id() %></td>
<td><%=bv.getVehicle_in_stock() %></td>
<td><%=bv.getStock_lasts_till() %></td>

<td>

<% 
		 String id = session.getAttribute("cOb").toString(); 
		 System.out.println(""+id);%>
<input type="radio" name="book"value="Booked,<%=id%>,<%=bv.getVehicle_id()%>,<%=bv.getManufacturer_name()%>,<%=bv.getExprice()%>,<%=bv.getColor()%>,<%=bv.getStock_lasts_till()%>,<%=bv.getBranch_location()%>"/>Book Now


</td></tr>




<% }%>












</table>
</div>
</br>
<input type="submit" value="Book Now">

</form>
</br>
<a href="Search_Page.jsp">Search Another vehicle</a>


<%@ include file="footer.jsp" %>


</body>
</html>