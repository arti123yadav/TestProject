

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p1.Connection1;

/**
 * Servlet implementation class ItemsInCart
 */
public class ItemsInCart extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			String uemail=request.getParameter("email");
			String upassword=request.getParameter("password");
			PrintWriter out= response.getWriter();
			out.println("Welcome <br><br>");
			try {
			Connection con=Connection1.getCon();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select firstname,lastname,mobile,email from register1 where email='"+uemail+"'and password='"+upassword+"'");
			if(rs.next()) {
				out.print("<br><br>");
				String firstname=rs.getString("firstname");
				String lastname=rs.getString("lastname");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				
			out.println("<html><body>"
					+ "Name: "+firstname+""+lastname+"<br>"
					+"mobile no:"+mobile+"<br>"
					+"email id :"+email
					+"<br><br><br>"
					+"Do you want to edit your profile ?");
			
			out.println("<a href=\"EditPro.jsp\">edit</a>");
			out.println("</body></html>");

			}
			}
			catch(Exception e) {
				e.printStackTrace();}
			

			
			
	}

}
