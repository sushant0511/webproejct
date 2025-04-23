<%@page import="com.java.test.DbConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

try
{
	
	
	Connection connection=DbConnection.getConnection();
	String username=request.getParameter("un");
	String pass=request.getParameter("pwd");
	Statement statement=connection.createStatement();
	ResultSet set=statement.executeQuery("select * from user");
	int flag=0;
	String user="";
	while(set.next())
	{
		if(username.equals(set.getString(2)) && pass.equals(set.getString(3)))
		{
		flag=1;
		
		session.setAttribute("user", username);
		}
		
	}
	System.out.println("I am working");
	if(flag==1)
	{
	
		response.sendRedirect("success.jsp");
	}
	else
	{
		response.sendRedirect("index.html");
	}
	
	
	
	
	
	
}
catch (Exception e) {
	System.out.println(e);
	response.sendRedirect("index.html");
}
%>





</body>
</html>