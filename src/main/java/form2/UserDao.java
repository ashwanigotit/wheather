package form2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
	
	private Connection con;
	
	public  UserDao(Connection con) {
		 this.con = con;
	}
	
	public boolean saveuser(User u) {
		boolean value =  false;
		
		try {
			
			String query = "Insert into user(name , email , password , gender) values (?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			
			psmt.setString(1, u.getName());
			psmt.setString(2, u.getEmail());
			psmt.setString(3, u.getPassword());
			psmt.setString(4, u.getGender());
			
			psmt.executeUpdate();
			value = true;

			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return value;
		
	}

}
