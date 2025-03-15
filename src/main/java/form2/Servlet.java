package form2;



import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

@MultipartConfig

public class Servlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void process(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		
		response.setContentType("Text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		User user = new User(name , email , password , gender);
		
		UserDao u = new UserDao(Connection2.getconnection());
		
		if(u.saveuser(user)) {
			out.println("Name" + name);
			out.println("Email" + email);
			out.println("Password" + password);
			out.println("Gender" + gender);

			
		}

		
		
		
	}
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		process(request , response);
	}
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
		process(request , response);
	}

}
