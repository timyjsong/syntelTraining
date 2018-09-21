package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class RegisterServlet extends HttpServlet {

	/*
	// execute at deployment
	public void init() {
		System.out.println("------------I AM INIT");
		
	}
	*/
	
	// execute at refresh page
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		request.getParameter("first");
		
		
		
		double ans = Calculator.addTwoNum(Double.parseDouble(request.getParameter("first")), Double.parseDouble(request.getParameter("second")));
		out.println("------------I AM SERVICE " + ans);

		
	}
	
	/*
	// execute at termination of server - when you stop the server
	public void destroy() {
		System.out.println("------------I AM DESTROY");
		
	}
	*/
}
