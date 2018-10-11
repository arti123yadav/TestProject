

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.Connection1;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	PrintWriter out=response.getWriter(); 
	HttpSession session=request.getSession();  
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		out.println("input field data");	
		out.println(email);	
		 out.println(password);	
		try {
			Connection con=Connection1.getCon();
			PreparedStatement st = con.prepareStatement("select email,password from register2 where email='"+email+"' and password='"+password+"'");
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
			    	 session.setAttribute("email",email);
					session.setAttribute("password",password);
					out.println(session.getAttribute("email"));
					out.println(session.getAttribute("password"));
					
					 RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
				       rd.forward(request, response);

					}
			 else{
					out.println("Login failed..enter correct email and password....");						
			      			 }
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}
