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
<%@include file="header1.jsp" %>
<br><br>
<h3>Success</h3>
<br>
<%=request.getAttribute("sOb") %>
<br><br><br>
<%@include file="footer.jsp" %>
</body>
</html>