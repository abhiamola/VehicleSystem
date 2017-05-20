<%@page import="java.util.ArrayList"%>
<%@page import="com.catp.model.AddRequestAdmin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="Script/script.js"></script>
<link rel="stylesheet" href="Style/style.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="header1.jsp" %>
<br>
<br>
<form method="POST" action="ApproveRequestController">
<div align="center">
<table border="1" class="table">
<tr>
<th>Branch Name</th>
<th>Vehicle Code</th>
<th>Requested Vehicles</th>
<th>Color</th>
<th>Available in Main Stock</th>
<th>Approve Stock Addition Request</th>
<th>Vehicles Approved</th>
<th>Comments</th>
</tr>
<%
ArrayList<AddRequestAdmin> list = new ArrayList<AddRequestAdmin>();
list = (ArrayList<AddRequestAdmin>)request.getAttribute("list");
int count = Integer.parseInt(request.getAttribute("count").toString());
for(AddRequestAdmin ara : list){
%>
<tr>
<td><%=ara.getbName() %></td>
<td><%=ara.getvCode() %></td>
<td><%=ara.getRequested() %></td>
<td><%=ara.getColor() %></td>
<td><%=ara.getMainStock() %></td>
<td><input type="radio" name="approveRequest" id="approveRequest" value="Approved,<%=ara.getbName()%>,<%=ara.getvCode()%>,<%=ara.getRequested()%>,<%=ara.getColor()%>,<%=ara.getMainStock()%>"></td>
<td><input type="text" name="vehiclesApproved" id="vehiclesApproved"></td>
<td><textarea  name="comments" id="comments"></textarea></td>

</tr>
<%
}
%>
</table>
</div>
<br>
<br>
<input type="submit" value="Approve Add On Request" onclick="return check();"/>
</form>
<!-- 
<form method="POST" action="Page">
<%
//out.println("value of count : "+Math.ceil(count/5));
//session.setAttribute("list",list);
 %>
<input type="submit" value="Next">
</form>
 -->
<br>
<br>
 <a href="home.jsp">Go Back</a>
 <br>
<br>

 <br>
<%@include file="footer.jsp" %>
</body>
</html>