

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.Connection1;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	response.setContentType("text/html");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	
	try {
	PrintWriter out= response.getWriter();
	 Connection con=Connection1.getCon();
	 
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from register2 where email='"+email+"'and password='"+password+"'");
	if(rs.next()) {
		 HttpSession sessions=request.getSession();  
	        sessions.setAttribute("email",email);
	        sessions.setAttribute("password",password); 
	        sessions.setAttribute("abc","login sucess");
	RequestDispatcher rd=request.getRequestDispatcher("/products.jsp?a=1");  
      rd.forward(request, response);  
     
		
	}else { 
         RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
        rd.include(request, response); 
        out.print("<center><b>Sorry UserName or Password Error!</b></center>"); 
		
	}
		}
	catch(Exception e) {
		e.printStackTrace();
	}

		}

	
}
