
import p1.Connection1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import p1.Connection1;
public class InsertionToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String savePath="D:\\images";

		String itemNO=request.getParameter("itemNO");
		String itemName=request.getParameter("itemName");
		String itemPrice=request.getParameter("itemPrice");
        String itemQuantity=request.getParameter("itemQuantity");
        String itemImage=request.getParameter("photo");
   
      try {
					
		Connection con=Connection1.getCon();
	     
		PreparedStatement ps=con.prepareStatement("insert into itemStore values(?,?,?,?,?)");
		ps.setString(1,itemNO );
		ps.setString(2,itemName );
		ps.setString(3,itemPrice );
		ps.setString(4,itemQuantity);
		ps.setString(5,itemImage);
		
	     int i= ps.executeUpdate();
		if(i!=0) {
			
			RequestDispatcher rd=request.getRequestDispatcher("/products.html");  
	         rd.forward(request, response); 
	         out.println("<center><b><br>item has been inserted</b></center><br>");
				
			
		}
		
		else {
			out.println("<br> <center><b><br>item has been inserted</b></center> ");
			//RequestDispatcher rd=request.getRequestDispatcher("/.html");  
	        // rd.include(request, response); 
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		
	
	}

	
		 

}
