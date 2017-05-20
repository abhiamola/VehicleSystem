<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style/style.css">
<script type="text/javascript" src="Script/validator.js">
</script>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>
<br>
<h3>Welcome to</h3> 
<h3>Online Vehicle Booking System</h3>
<br><br>
Login Here
<br>
<form name="myForm" action="LoginController" method="post" >
<div align="center">
<table class="tb">
<tr align="center">
<td>User ID</td>
<td><input type="text" name="uId"/></td>
<td class="msg" id="umsg"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass"/></td>
<td class="msg" id="pmsg"></td>
</tr>
</table>
</div>
<input type="submit" value="Login" onClick="return validLogin();"/>
</form>
<br>
<br>
<h3>New Users Click here</h3>
<a href="Register.jsp">New User Registration</a>

<br>
<br>
<br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>