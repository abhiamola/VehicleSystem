<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<%String value=(String)request.getAttribute("status"); %>
<% System.out.println("hello updated pending request jsp2");%>
<br>
<br>
<br>
<a href="admin.jsp">User <%= value %> successfully click here to go to home page</a>  
<br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>