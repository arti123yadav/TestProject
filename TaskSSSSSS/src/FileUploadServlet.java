

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="images";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	String savePath="D:\\java learn\\workspace\\TaskSSSSSS\\WebContent\\assets\\images"+File.separator+SAVE_DIR;
	File fileSaveDir=new File(savePath);
	String Fname=request.getParameter("Fname");
	String Lname=request.getParameter("Lname");
	Part part=request.getPart("file");
	String fileName=extractFileName(part);
	part.write(savePath+File.separator+fileName);
	try {
		Class.forName("com.mysql.jdbc.Driver");
  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ducat", "root", "root");
 PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
 ps.setString(1, Fname);
 ps.setString(2, Lname);
 String filePath=savePath+File.separator+fileName;
 ps.setString(3, filePath);
 ps.executeUpdate();
 out.print("<center><h1>image inserted</h1></center>");
		}
		

catch(Exception e) {
e.printStackTrace();
}
	

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");  
	       String[] items = contentDisp.split(";");  
	       for (String s : items) {  
	           if (s.trim().startsWith("filename")) {  
	               return s.substring(s.indexOf("=") + 2, s.length()-1);  
	           }  
	       }
		return null;  	}

}
