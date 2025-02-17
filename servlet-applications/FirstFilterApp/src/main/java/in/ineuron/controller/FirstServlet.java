package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("servlet is loaded");
	}
   
    public FirstServlet() {
        System.out.println("servlet is instantiated");
    }
    
    @Override
    public void init() {
    	System.out.println("servlet is intialized");
    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>This is the response from Target Servlet </h1>");
	}
    
    @Override
	public void destroy() {
		System.out.println("servlet de-instantiated");
	}
}
