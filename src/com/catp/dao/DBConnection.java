package com.catp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import com.catp.exception.*;

public class DBConnection {
public static Connection getConnection() throws VException
{
	try
	{
		ResourceBundle rs = ResourceBundle.getBundle("myDB");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = rs.getString("url");
		String uname= rs.getString("uname");
		String pass = rs.getString("pass");
		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	catch(Exception e)
	{
		throw new VException();
	}
	
}
}
