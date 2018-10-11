package p1;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connection1 {
		 static Connection con=null;
			public static Connection getCon() {
			try {
						if(con==null) {
					Class.forName("com.mysql.jdbc.Driver");
				   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ducat", "root", "root");
				    return con;
				    	}
						else {
							return con;
						}
				}
			catch(Exception e) {
				e.printStackTrace();
				}
					return con;
					}
			}

	
	
	
