package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("servlet loaded ");
	}
   
    public TargetServlet() {
        System.out.println("servlet instantiated");
        
    }

    public void init() {
    	System.out.println("servlet intialized");
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request processing phase");
		PrintWriter out = response.getWriter();
		out.println("<h1>This is the response from Target Servlet ... </h1>");
	}
	
	public void destroy() {
		System.out.println("servlet de-instantiated");
		 
	}

	
}
