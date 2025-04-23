

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.test.DbConnection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("un");
		String pass=request.getParameter("pwd");
		String add=request.getParameter("add");
		String zipc=request.getParameter("zip");
		String mobile=request.getParameter("mob");
		
	try
	{
		Connection connection=DbConnection.getConnection();
		Statement statement=connection.createStatement();
		String insertQuery="insert into user(`name`,`password`,`address`,`zip`,`mobile`) values('"+username+"','"+pass+"','"+add+"','"+zipc+"','"+mobile+"')";
		statement.executeUpdate(insertQuery);
		response.sendRedirect("index.html");
		
	}
	
	catch (Exception e) {
		System.out.println(e);
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
