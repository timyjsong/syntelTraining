package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String ecity=request.getParameter("ecity");
		double esalary=Double.parseDouble(request.getParameter("esalary"));
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Registration Success</title></head><body>");
		out.println("<h1>Employee Registered Successfully.....<br>");
		out.println("Employee ID : " + eid);
		out.println("<br>");
		out.println("Employee Name : " + ename);
		out.println("<br>");
		out.println("Employee City : " + ecity);
		out.println("<br>");
		out.println("Employee Salary : " + esalary);
		out.println("<br>");
		out.println("</body></html>");
		out.println("<br>");
	}

}
