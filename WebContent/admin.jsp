<% 
   Object a=session.getAttribute("AOB");

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
<script src="jquery-3.1.1.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
<link rel="stylesheet" href="Style/ss.css"/>
</head>
<body>
<%@ include file="header.jsp" %>
<%@include file="header1.jsp" %>
<br><br><br>
<h3>Welcome Administrator</h3>
<br><br>
<form method="post" action="ApproveController">
<input type="submit" value="All Account Approval Requests" />
</form>
<br>
<br>

<form method="post" action="RoleController">
<p><b>Account Approval request on the basis of </b>
<select name ="role">
  <option  value="Customer">Customer</option>
  <option  value="Branch Admin">Branch Admin</option>
</select>
<input type="submit"  value="submit" />
</p>
</form>
<br>
<br>
<form method ="post" action="StatusController">
<p><b>Account Approval request on the basis of </b>
<select name ="status">
  <option  value="Approve">Approve</option>
  <option  value="Pending">Pending</option>
  <option  value="Reject">Reject</option>
</select>
<input type="submit" value="submit" />
</p>
</form>
<br>
<br>
<br>
<a href="AdminHome.jsp">Go Back</a>
<br><br>
<br>
<%@ include file="footer.jsp" %>
</body>
</html>