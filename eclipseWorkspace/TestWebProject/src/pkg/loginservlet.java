package pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("uname");
		String userpass = request.getParameter("upass");
		
		
		
		if(username.length()>5 && userpass.equals("syntel123$"))
		{
			response.sendRedirect("http://localhost:8044/TestWebProject/EMS.html");
		}
		else
		{
			response.sendRedirect("http://localhost:8044/TestWebProject/Error.html");
		}
	}
}