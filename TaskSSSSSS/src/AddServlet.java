

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.Connection1;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("item added");
		String material=request.getParameter("material");
		String quantity=request.getParameter("quantity");
		//String price=request.getParameter("price");
		String color=request.getParameter("color");
		float qty=Float.parseFloat(quantity);
		float price=(float) 140.0;
		float total_price=qty*price;
		HttpSession session =request.getSession();
		List<Cart> list= (List<Cart>) session.getAttribute("list");

		  if(list==null){
		    list =new ArrayList<>();
		  }
		  // Add the name & cost to List
		  list.add(new Cart());

		  session.setAttribute("list",list);

	   
	
		 try {
				
				Connection con=Connection1.getCon();
			     
				PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?)");
				ps.setString(1,quantity );
				ps.setString(2,color );
				ps.setString(3,material );
								
			     int i= ps.executeUpdate();
				if(i!=0) {
					out.println("<center><b><br>item has been added to cart</b></center><br>");
			         out.print("<center><b><br>total price is </b></center><br>"+total_price);

					RequestDispatcher rd=request.getRequestDispatcher("/ItemsInCart");  
			         rd.forward(request, response); 
			        
					
				}
				
				else {
					out.println("<br> <center><b><br>try again</b></center> ");
					//RequestDispatcher rd=request.getRequestDispatcher("/.html");  
			        // rd.include(request, response); 
				}
				}
				catch(Exception e) {
					e.printStackTrace();
					}

		
		
		
		}

}
class Cart{
	   String quantity;
	   String material;
	   //double cost;
	  // Getter & Setter

	}
