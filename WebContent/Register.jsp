<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css">
<script type="text/javascript" src="Script/validator.js">
</script>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>
<h3>Register Here</h3>
<form name="myForm" action="RegisterController" method="post">
<div align="center">
<table align="center">
<tr>
<td>User Name</td>
<td><input type="text" name="uName"/></td>
<td class="msg" id="unmsg"></td>
</tr>
<tr>
<td>User ID</td>
<td><input type="text" name="uId"/></td>
<td class="msg" id="umsg"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass"/></td>
<td class="msg" id="pmsg"></td>
</tr>

<tr>
<td>Re-enter Password</td>
<td><input type="password" name="pass1"/></td>
<td class="msg" id="pmsg1"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
<td id="emsg" class="msg"></td>
</tr>
<tr>
<td>Role</td>
<td>
<select name="uRole">
<option value="Customer">Customer</option>
<option value="Branch Admin">Branch Admin</option>
</select>
</td>
</tr>
</table>
</div>
<input type="submit" value="Register" onClick="return validRegister();"/>
</form>
<br><br><br>
<%@include file="footer.jsp" %>
</body>
</html>