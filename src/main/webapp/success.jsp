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
<h2>Connection success</h2>
<% String un=session.getAttribute("user").toString();  %>
<h3>Welcome <%out.println(un); %></h3>

<%
try
{
	
	
	Connection connection=DbConnection.getConnection();
	Statement statement=connection.createStatement();
	String uquery="update user SET `address`='NY' where name='"+un+"'";
	statement.executeUpdate(uquery);
	System.out.println("Data updated");
	%>
	
	<form>
	Name <input type="text" name="uname">
	<input type="submit">
	</form>
	
	<%
	
}


catch (Exception e) {
	System.out.println(e);
	response.sendRedirect("index.html");
}


%>



</body>
</html>