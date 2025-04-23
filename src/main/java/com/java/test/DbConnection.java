package com.java.test;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	static Connection connection;
	
	public static Connection getConnection()
	{
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1011","root","root");
		
			
		}
		
		catch (Exception e) {
			System.out.println(e);
			
		}
		return connection;
	}
	
	
}
