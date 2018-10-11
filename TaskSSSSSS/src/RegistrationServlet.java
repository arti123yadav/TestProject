import p1.Connection1;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("hello");
	try {
			Connection con=Connection1.getCon();
		String title=request.getParameter("title");
		String first_name=request.getParameter("inputFname");
		String last_name=request.getParameter("inputLname");
		String email=request.getParameter("email");
		String dob=request.getParameter("date");
		String password=request.getParameter("password");
		

			out.println(first_name+"<br><br>"+last_name+
				"<br><br>"+dob+"<br><br> "
				+email+"<br><br> "+password+"<br><br>");
		
		PreparedStatement ps=con.prepareStatement("insert into register2 values(?,?,?,?,?)");
		ps.setString(1, title);
		ps.setString(1,first_name );
		ps.setString(2,last_name );
		ps.setString(3,email );
		ps.setString(4,password);
		ps.setString(5,dob);
		int i= ps.executeUpdate();
		if(i!=0) {
			out.println("<br><br><br> Record has been inserted<br><br><br><br>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
	         rd.include(request, response); 
			
		}
		
		else {
			out.println("<br> not inserted ");
			RequestDispatcher rd=request.getRequestDispatcher("/register.html");  
	         rd.forward(request, response); 
		}
		
	}

		
		catch(Exception e) {
			System.out.println(e);
			}
		
	}
	
	}

