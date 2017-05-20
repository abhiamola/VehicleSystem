<% 
   Object a=session.getAttribute("cOb");

  if (a == null)
  {
    %><jsp:forward page="index.jsp" /><%
  }
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Script/ValidateSearch.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body bgcolor="cdb79e">
<%@ include file="header.jsp" %>
<%@include file="header1.jsp" %>
<h2>Search your desired Ride here</h2> </br>
<div id="Error"> <font color="red"></font></div>
<form name="search_form" method="post"  action="SearchController">
<div  align="center">
<table >
<tr>
<td>
Manufacturer : </td><td><select name="manufacturer">
<option selected="selected" value="MarutiSuzuki">Maruti Suzuki</option>
<option value="Honda">Honda</option>
<option value="Toyota">Toyota</option>
<option value="Chevrolet">Chevrolet</option>
<option value="Hyundai">Hyundai</option>
<option value="Ford">Ford</option>
</select></br></br>
</td>
</tr>
<tr>
<td>
Price Range : </td><td><select name="lower_price">
<option selected="selected" value="100000">100000</option>
<option value="500000">500000</option>
<option value="700000">700000</option>
<option value="1000000">1000000</option>
<option value="1200000">1200000</option>
<option value="1500000">1500000</option>
<option value="2000000">2000000</option></select> &nbsp &nbsp &nbsp - &nbsp &nbsp <select name="upper_price">
<option selected="selected" value="100000">100000</option>
<option value="500000">500000</option>
<option value="700000">700000</option>
<option value="1000000">1000000</option>
<option value="1200000">1200000</option>
<option value="1500000">1500000</option>
<option value="2000000">2000000</option> 
</select></br></br>
</td>
</tr>
<tr>
<td>
Color : </td><td><select name="color">
<option selected="selected" value="Red">Red</option>
<option value="Silver">Silver</option>
<option value="White">White</option>
<option value="Blue">Blue</option>
<option value="Black">Black</option>
</select></br></br>
</td>
</tr>
<tr>
<td>
Seating Capacity : </td><td><input type="text" name="seating"></br></br>
</td>
</tr>
<tr>
<td>
Branch Location :  </td><td><select name="location">
<option selected="selected" value="Amritsar">Amritsar</option>
<option value="Banglore">Bengaluru</option>
<option value="Chennai">Chennai</option>
<option value="Delhi">Delhi</option>
<option value="Jaipur">Jaipur</option>
<option value="Mumbai">Mumbai</option>
<option value="Pune">Pune</option>
</select></br></br>
</td>
</tr>


<tr>
<td>
<input type="submit" name="searchVehicle" value="Search" onclick="return retValid()"></input>
&nbsp &nbsp</td>
<td>
<input type="reset" name="Reset" value="Reset">
</td>




</table>


</div>


</form>
<br>

<form method="post" action="UserAllBookingController1">

<% 
		 String id = session.getAttribute("cOb").toString(); 
		 System.out.println(""+id);%>
		 
<input type="hidden" name ="allbookinguid" value="<%=id %>">
<input type="submit" value ="View Past Bookings">

 </form>

<br>

<%@ include file="footer.jsp" %>

</body>
</html>