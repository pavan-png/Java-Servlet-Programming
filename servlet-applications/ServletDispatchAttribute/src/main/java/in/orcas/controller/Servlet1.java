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
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pavan", "net worth is 1 trillion");
		request.setAttribute("datta", "networth is 10 billion");
		request.setAttribute("srinivas", "networth is 5 billion");
		
		PrintWriter out = response.getWriter();
		out.println("<h1> this is servlet 1</h1>");
		RequestDispatcher reqDisp= request.getRequestDispatcher("/test2");
		reqDisp.forward(request, response);
	}

}
