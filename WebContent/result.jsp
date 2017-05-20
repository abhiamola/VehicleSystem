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
<%@include file="header1.jsp" %>
<h1 id="aa"><%=request.getAttribute("result") %></h1>
<br>
<a href="AdminHome.jsp">Click Here</a> to goto Admin Home
<br>
<br>

<br>
<%@include file="footer.jsp" %>
</body>
</html>