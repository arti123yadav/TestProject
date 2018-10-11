
import p1.Connection1;
		import java.sql.*;

		import java.io.IOException;
		import java.io.PrintWriter;

		import javax.servlet.RequestDispatcher;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	try {
		Connection con= Connection1.getCon();
        String title=request.getParameter("title");
		String first_name=request.getParameter("inputFname");
		String last_name=request.getParameter("inputLname");
		String email=request.getParameter("email");
		String dob=request.getParameter("date");
		String password=request.getParameter("password");
		if(email.equals(null)||password.equals("")) {
			out.println("Enter email and password");
		}
		else {
		out.print("hello "+title+" "+first_name+" "+last_name+"<br>");
		PreparedStatement ps=con.prepareStatement("insert into register2 values(?,?,?,?,?,?)");
		ps.setString(1, title);
		ps.setString(2,first_name );
		ps.setString(3,last_name );
		ps.setString(4,email );
		ps.setString(5,password);
		ps.setString(6,dob);
		int i= ps.executeUpdate();
		if(i!=0) {
			out.println("<br><br><br><b> Record has been inserted</b><br><br><br><br>");
			//RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
	         //rd.include(request, response); 
			}
		else {
			out.println("<br> <b>not inserted </b>");
			//RequestDispatcher rd=request.getRequestDispatcher("/register.html");  
	        // rd.forward(request, response); 
		}	}
	}
	catch(Exception e) {
			System.out.println(e);
			}		
	}
}
