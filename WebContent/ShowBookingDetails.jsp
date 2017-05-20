
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.catp.model.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Booking Requests</title>

<link href="Style/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file="header.jsp" %><br>
<h1 align="center">Approve Vehicle Requests</h1><br>
<%!
int cnt=0;
void cc(int l)
{
	cnt=cnt+l;
}
%>

<% ArrayList<Booking> al2 = new ArrayList<Booking>();
al2 = (ArrayList<Booking>)request.getAttribute("bookingob"); 

%>
<div align="center">
<table border="1" class="table">
<tr> <td align="center"> <b>CustomerId</b></td>
<td align="center"> <b>Vehicles Code</b></td>
<td align="center"><b>ManufacturesName</b></td>
<td align="center"> <b>No of vehicles available in stock</b></td>
<td align="center"> <b>Approve Booking</b></td>
<td align="center"> <b>comments</b></td>
<td align="center"> <b>Update Approval</b></td>
</tr>

<%int i=0;
int len=al2.size()+1;
//cnt=Integer.parseInt(request.getParameter("pp"));
for(Booking c:al2){ 
	if(i>=(cnt*5) && i<((cnt+1)*5))
	{
%>
<tr><td align="center"><%=c.getCustomerName() %></td>
<td align="center"><form action="RetVehicleController" method="post">
<input type="submit" name ="vehcode" class="button" value="<%=c.getVehicleCode() %>"></form></td>
<td align="center"><%=c.getManufactureName() %></td>
<td align="center"><%=c.getStockNo() %></td>
<form action="UpdateVehicleController" method="post"><td><div align="center"><input type="checkbox" id="approval" name="approval" value="Y,<%=c.getCustomerName()%>,<%=c.getVehicleCode() %>,<%=c.getStockNo() %>"></div>
<div id="cMsg"></div></td>
<td align="center"><textarea rows="4" cols="10" name="cmmnt" id="cmmnt"></textarea></td>
<td align="center">
<input type="submit" name ="save" value="update" onClick = "if(!this.form.approval.checked)
{
	    alert('You must approve first.');
	    return false;
	}"></td></form>
<% }i++;} %>

</table>
</div>
<br><br>
<%
for(int k=1;k<=len/5;k++)
{
	%>
	<a href="ShowBookingDetails.jsp?pp=1">ss</a>
<%}
	
	%>
<br><br>
<form action="RequestVehicleController" method="post"><div align="center"><input type="submit" class="button" align="center" name ="vehreq" value="Request More Vehicles"></div></form><br>
<div align="center"><form action = "BAdminHome.jsp"><input type="submit" class="button" value="Go Back To Booking Requests"></form></div>
<br><br><%@include file="footer.jsp" %>
</body>
</html>