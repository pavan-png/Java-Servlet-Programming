package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = 	response.getWriter();
	System.out.println("control comes to servlet 1 ");
	out.println("<h1>Welcome to Servlet 1</h1>");
	RequestDispatcher reqDis = request.getRequestDispatcher("/test2");
	reqDis.forward(request, response);
		
	}

}
