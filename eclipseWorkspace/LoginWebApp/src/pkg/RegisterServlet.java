package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/*
	// execute at deployment
	public void init() {
		System.out.println("------------I AM INIT");
		
	}
	*/
	
	// execute at refresh page
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		int eId = Integer.parseInt(request.getParameter("eId"));
		String eName = request.getParameter("eName");
		String ePhone = request.getParameter("ePhone");
		String eCity = request.getParameter("eCity");
		String isActive = request.getParameter("isActive");
		
		int ret = RegistrationLogic.insertCustomer(eId, eName, ePhone, eCity, isActive);
		if(ret>0) {
			out.println("<html>");

			out.println("<body>");
			out.println("Customer "+eId+" has been added ----");
			out.println();
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/ShowAllEmployeesServlet");
			rd.include(request, response);
			out.println("</body>");
			out.println("</html>");

			
			// response.sendRedirect("ShowAllEmployeesServlet");
		}
		else
			out.println("Customer "+eId+" has NOT been added ----");

		//double ans = Calculator.addTwoNum(Double.parseDouble(request.getParameter("first")), Double.parseDouble(request.getParameter("second")));
		//out.println("------------I AM SERVICE " + ans);

		
	}
	
	/*
	// execute at termination of server - when you stop the server
	public void destroy() {
		System.out.println("------------I AM DESTROY");
		
	}
	*/
}
