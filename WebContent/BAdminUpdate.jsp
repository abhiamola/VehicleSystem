<% 
   Object a=session.getAttribute("bOb");

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
<h3>Welcome Branch Admin</h3>
<br>
<form name="myForm" action="BAdminContoller" method="post">
<div align="center">
<table align="center">
<tr>
<td>Login Id</td>
<td><%=session.getAttribute("bOb") %></td>
</tr>
<tr>
<td>Branch Location</td>
<td><input type="text" name="bLoc"></td>
<td id="bmsg" class="msg"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="add"></td>
<td id="amsg" class="msg"></td>
</tr>
<tr>
<td>Mail ID</td>
<td><input type="text" name="email"></td>
<td id="emsg" class="msg"></td>
</tr>
<tr>
<td>Phone</td>
<td><input type="text" name="phNo"></td>
<td id="pmsg" class="msg"></td>
</tr>
</table>
</div>
<input type="submit" value="Update Info" onclick="return validBranchUpd();"/>
</form>
<br><br>
<br>
 <a href="BAdminHome.jsp">Go Back</a>
 <br>
 <br>
<br>
<%@include file="footer.jsp" %>

</body>
</html>