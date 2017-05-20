


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.catp.model.*"%>
   <%@page import="com.catp.controller.UpdateApproval"%>
   <%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="Script/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="Style/style.css"/>
<script>
function a(id){
$(document).ready(function(){
	
	$('#sub').each(function(){
		
		var a=	$('input:radio[name=changeStatus]:checked').val();
		
		
		var split = a.substring(0,a.indexOf(','));
		var id1=a.substring(a.indexOf(',')+1);
		
		
		$("#"+id).text(split);
       
		 
	});

	});
}

</script>
</head>
<body>

<%@include file="header.jsp" %>
<%@include file="header1.jsp" %>
<br><br><br>
<h3>OverAll Requests for approval</h3>
<br><br>
<form method="post" action="UpdateApproval" >
<%
User_Approval u=new User_Approval();
ArrayList<User_Approval> uA=new ArrayList<User_Approval>();


 uA=(ArrayList<User_Approval>)request.getAttribute("UserList");

 System.out.println("apc"+uA);
 System.out.println("asdbsdh"+uA);
 for(User_Approval a:uA){
	 System.out.println(a.getUserId());
 }
//User_Approval a=new User_Approval();
%>
<div align="center">
<table  border="1" class="table" id="table" >
<form  method="post" action="UpdateApproval" >
<tr> <td> <b>UserId&nbsp&nbsp</b></td>
<td> <b>Role&nbsp&nbsp </b></td>
<td><b>Created Date&nbsp&nbsp</b></td>
<td> <b>Status&nbsp&nbsp</b></td>
<td> <b>Change Status&nbsp&nbsp</b></td>
</tr>
<% for(User_Approval a:uA){%>
<tr> <td> <b><%=a.getUserId() %></b></td>&nbsp&nbsp
<td> <b><%=a.getRole() %></b></td>&nbsp&nbsp
<td><b><%=a.getCreatedDate() %></b></td>&nbsp&nbsp;
<td><b id="<%=a.getUserId()%>"><%=a.getStatus()%> </b></td>&nbsp&nbsp  

<td id="sub" >	<b >
     
       <input type="radio" name="changeStatus" value="Approve,<%=a.getUserId()%>"  onclick="return a(<%=a.getUserId()%>)" /> Approve

        <input   type="radio" name="changeStatus"    value="Reject,<%=a.getUserId()%>"  onclick="return a(<%=a.getUserId()%>)" /> Reject
 
        <input type="radio" name="changeStatus"  value="Pending,<%=a.getUserId()%>"   onclick="return a(<%=a.getUserId()%>)" /> Pending
          
            </b> </td>
          
            <% 
            }%></tr>
            
</table>
</div>
<br>
<br>
<br>
 <input type="submit"  value="submit"  id="button"/> 
<%


session.setAttribute("obj",uA);  
%>
 </form>
 <br>
 <a href="AdminHome.jsp">Go Back</a>
 <br>
 <br>


 
</body>
</html>