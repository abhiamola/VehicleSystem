<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.catp.model.User_Approval"%>
   <%@page import="com.catp.controller.UpdateApproval"%>
   <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Style/style.css"/>
 <script type="text/javascript" src="jquery-1.11.2.min.js"></script>
<script type="text/javascript">



</script>
<meta http-equiv="refresh" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@include file="header.jsp" %>
<%@include file="header1.jsp" %>
<br>
<br>
<form method="post" action="UpdateApproval">
<%
//User_Approval u=new User_Approval();
ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
HttpSession session1=request.getSession(); 
 uA=(ArrayList<User_Approval>)request.getAttribute("UserList");
 System.out.println("apc"+uA);
 System.out.println("asdbsdh"+uA);
 /*for(User_Approval a:uA){
	 System.out.println(a.getUserId());
 }*/
//User_Approval a=new User_Approval();
%>
<div align="center">
<table border="1" class="table">
<form method="post" action="UpdateApproval">
<tr> <td> <b>UserId&nbsp&nbsp</b></td>
<td> <b>Role&nbsp&nbsp </b></td>
<td><b>Created Date&nbsp&nbsp</b></td>
<td> <b>Status&nbsp&nbsp</b></td>

</tr>
<% for(User_Approval a:uA){%>
<tr> <td> <b><%=a.getUserId() %></b></td>&nbsp&nbsp
<td> <b><%=a.getRole() %></b></td>&nbsp&nbsp
<td><b><%=a.getCreatedDate() %></b></td>&nbsp&nbsp
<td><b><%=a.getStatus() %></b></td>&nbsp&nbsp

            <% 
            }%></tr>
</table>
</div>
<%


//session1.setAttribute("obj",uA);  
%>
 </form>
 <br>
 <br>
  <a href="admin.jsp">Go Back</a>
  <br><br>
 <%@include file="footer.jsp" %>
</body>
</html>