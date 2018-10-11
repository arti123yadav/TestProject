

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.Connection1;

public class AddItemToDbServlet extends HttpServlet {
	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String material=request.getParameter("material");
		String quantity=request.getParameter("quantity");
		//String price=request.getParameter("price");
		String color=request.getParameter("color");
		float qty=Float.parseFloat(quantity);
		float price=(float) 140.0;
		float total_price=qty*price;
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		out.println(email);
		  try {
				Connection con=Connection1.getCon();
			     PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?)");
				ps.setString(1,quantity );
				ps.setString(2,color );
				ps.setString(3,material );
				ps.setString(4,email);				
			     int i= ps.executeUpdate();
				if(i!=0) {
					RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
				       rd.forward(request, response);
					
			         out.print("<center><b><br>total price is </b></center><br>"+total_price);
			         }
				
				else {
					out.println("<br> <center><b><br> go back..try again</b></center> ");
					
				}
				}
				catch(Exception e) {
					e.printStackTrace();
					}
}}
