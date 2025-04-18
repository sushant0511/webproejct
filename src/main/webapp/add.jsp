<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
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

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1_jerry", "root", "oot");
	System.out.println(connection);
	//Statement statement=connection.createStatement();
	if(connection!=null)
	{
	out.print("connection success");
	response.sendRedirect("success.jsp");
	}
		
}
catch (Exception e) {
	System.out.println(e);
	response.sendRedirect("index.html");
}

%></body>
</html>