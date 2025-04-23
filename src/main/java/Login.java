

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.test.DbConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			
			
			Connection connection=DbConnection.getConnection();
			String username=request.getParameter("un");
			String pass=request.getParameter("pwd");
			Statement statement=connection.createStatement();
			ResultSet set=statement.executeQuery("select * from user");
			int flag=0;
			while(set.next())
			{
				if(username.equals(set.getString(2)) && pass.equals(set.getString(3)))
				{
				flag=1;
				}
				
			}
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
