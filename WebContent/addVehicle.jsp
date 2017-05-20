<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
<script type="text/javascript" src="Script/script.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="header1.jsp" %>
<h1>Enter the following details</h1>
<form method="POST" action="AddNewVehicle" id="frm1">
<div align="center">
<table id="tbl1">
<tr>
<td>Manufacturer's Name</td>
<td><input type="text" name="mName" id="mName"></td>
<td id="mNameMsg"></td>
</tr>
<tr>
<td>Vehicle Code</td>
<td><input type="text" name="vCode" id="vCode"></td>
<td id="vCodeMsg"></td>
</tr>
<tr>
<td>Ex Showroom Price</td>
<td><input type="text" name="exPrice" id="exPrice"></td>
<td id="exPriceMsg"></td>
</tr>
<tr>
<td>Colour</td>
<td><input type="text" name="colour" id="colour"></td>
<td id="colourMsg"></td>
</tr>
<tr>
<td>No. of Vehicles Available</td>
<td><input type="text" name="vAvailable" id="vAvailable"></td>
<td id="vAvailableMsg"></td>
</tr>
<tr>
<td>Seating Capacity</td>
<td><input type="text" name="sCapacity" id="sCapacity"></td>
<td id="sCapacityMsg"></td>
</tr>
<tr>
<td>Stock lasts till</td>
<td><input type="text" name="stockDate" id="stockDate"></td>
<td id="stockDateMsg"></td>
</tr>
<tr>
<td>Branch Location</td>
<td><input type="text" name="bLocation" id="bLocation"></td>
<td id="bLocationMsg"></td>
</tr>
<tr>
<td><input type="submit" value="Submit" onclick="return validateForm();"/></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</div>
</form>
<br>
<br>
<br>
<a href="home.jsp">Go Back</a>
<br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>