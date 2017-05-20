<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<%
Connection con = com.catp.dao.DBConnection.getConnection();
Statement stmt = con.createStatement();
String insertQuery = "insert into addOnAdmin values(?,?,?,?,?,?,?)";
String query = "select vehicles_available from vehicles where vehicle_code=? and branch=?";
ResultSet rs = stmt.executeQuery("select * from requestMoreVehicles");
Statement st = con.createStatement();

PreparedStatement pstmt = con.prepareStatement(query);
PreparedStatement pstmt1 = con.prepareStatement(insertQuery);
String branchName = "";
String vehicleCode = "";
int requested = 0;
String color = "";
int mainStock=0;
String approve = "";
String comments = "";
%>
<form method="POST" action="ApproveRequestController">


<%while(rs.next()){
	branchName = rs.getString(6);
	vehicleCode = rs.getString(1);
	requested = rs.getInt(5);
	color = rs.getString(4);
	
	pstmt.setString(1,vehicleCode);
	pstmt.setString(2,"Main");
	ResultSet rs1 = pstmt.executeQuery(); 
	while(rs1.next()){
		mainStock = rs1.getInt(1);
	}
	approve = "Pending";
	comments = "Will be Updated Shortly";
	pstmt1.setString(1,branchName);
	pstmt1.setString(2,vehicleCode);
	pstmt1.setInt(3,requested);
	pstmt1.setString(4,color);
	pstmt1.setInt(5,mainStock);
	pstmt1.setString(6,approve);
	pstmt1.setString(7,comments);
	pstmt1.executeUpdate();
}
ResultSet rs2 = st.executeQuery("select * from addOnAdmin");
while(rs2.next()){
%>
<table>
<tr>
<th>Branch Name</th>
<th>Vehicle Code</th>
<th>No of Vehicles Requested</th>
<th>Color</th>
<th>No of Vehicles in Main Stock</th>
<th>Approve Stock Addition Request</th>
<th>Comments</th>
</tr>
<tr>
<td><%=rs2.getString(1) %></td>
<td><%=rs2.getString(2) %></td>
<td><%=rs2.getInt(3) %></td>
<td><%=rs2.getString(4) %></td>
<td><%=rs2.getInt(5) %></td>
<td><%=rs2.getString(6) %></td>
<td><%=rs2.getString(7) %></td>
</tr>
</table>
<%
}
%>
<input type="submit" value="Approve AddOn Request">
</form>
<%@include file="footer.jsp" %>
</body>
</html>