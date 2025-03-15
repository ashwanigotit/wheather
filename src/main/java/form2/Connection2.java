package form2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection2 {
	
	private static Connection con;
	
	public static Connection getconnection() {
		
		try {
			
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/form" ,"root" ,"root");
				System.out.println("value of con" + con) ;

			
			}
		}
			
	
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
		
	}