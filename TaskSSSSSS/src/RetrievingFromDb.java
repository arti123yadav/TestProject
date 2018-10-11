
import p1.Connection1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class RetrievingFromDb extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("Retrive data  <br><br>");
		try {
			Connection con=Connection1.getCon();
		String itemNo=request.getParameter("itemNo");
		out.println(itemNo);
		 File file=new File("d:\\image1.png");
         FileOutputStream fos=new FileOutputStream(file);
         byte b[];
         Blob blob;
			PreparedStatement ps=con.prepareStatement("select * from itemStores where itemNo='"+itemNo+"'");
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){//now on 1st row  
			 String itemNoo=rs.getString(1); 
			 String itemName=rs.getString(2);
			 String itemPrice=rs.getString(3);
			 String itemQuantity=rs.getString(4);
			 blob=rs.getBlob(5);
             b=blob.getBytes(1,(int)blob.length());
             fos.write(b);
	
	out.print("<br>"+itemNoo+"<br>"+itemName+"<br>"+itemPrice+"<br>"+itemQuantity);
	}
		}
	 catch (Exception e) {
			e.printStackTrace();
		}
		}

}
