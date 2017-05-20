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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
<script type="text/javascript" src="Script/validator.js">
</script>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="header1.jsp" %>
<br><br>
<h3>Welcome Customer</h3>
<br>
<form name="myForm" action="CusUpdateController" method="post">
<div align="center">
<table align="center">
<tr>
<td>Login Id</td>
<td><%=session.getAttribute("cOb") %></td>
</tr>
<tr>
<td>Customer Name</td>
<td><input type="text" name="cName"></td>
<td id="cmsg" class="msg"></td>
</tr>
<tr>
<td>Date Of Birth</td>
<td><input type="text" name="dob"></td>
<td id="dmsg" class="msg"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="add"></td>
<td id="amsg" class="msg"></td>
</tr>
<tr>
<td>Phone Number</td>
<td><input type="text" name="phNo"></td>
<td id="pmsg" class="msg"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
<td id="emsg" class="msg"></td>
</tr>
<tr>
<td>Occupation</td>
<td><input type="text" name="occ"></td>
<td id="omsg" class="msg"></td>
</tr>
</table>
</div>
<input type="submit" value="Update Info" onclick="return validUpd();"/>
</form>
<br>
 <a href="CustomerHome.jsp">Go Back</a>
<br><br><br>
<%@include file="footer.jsp" %>
</body>
</html>