package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllEmployeesServlet
 */
@WebServlet("/ShowAllEmployeesServlet")
public class ShowAllEmployeesServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		List<Customer> list = ShowAllEmployeesLogic.selectAllEmployee();
		
		out.println("<table border='2' cellspacing='4' cellpadding='4'>");
		for(Customer c : list) {
			out.println("<tr>");
			out.println("<td>"+c.getCustId()+"</td>");
			out.println("<td>"+c.getCustName()+"</td>");
			out.println("<td>"+c.getCustCity()+"</td>");
			out.println("<td>"+c.getCustPhone()+"</td>");
			out.println("<td>"+c.getIsActive()+"</td>");
			// c.display();
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
