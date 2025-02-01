package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LocalDateTime date = LocalDateTime.now();
		int hour = date.getHour();
		System.out.println("hour :"+hour);
		String msg = "";
		if(hour >=1 && hour<12) {
			msg = "good morning";
		}
		else if(hour>=13 && hour<16) {
			
			msg = "good afternoon";
		}
		else if(hour>=16 && hour<20) {
			
			msg = "good evening";
		}
		else {
			msg = "good night";
		}
		out.println("<h1 style='color: red; text-align: center; '>WELCOME TO SERVLET CODING ...</h1>");
		out.println("<h1 style='color:blue; text-align: center;'>The current date and time is :: " + date + "</h1>");
		out.println("<h1 style='color:blue; text-align: center; '>Greeting from the Server :: " + msg + "</h1>");
		out.println("<br/>Servlet Request object address is :: " + request.hashCode());
		out.println("<br/>Servlet Response object address is :: "+response.hashCode());
		out.println("<br/>Current Servlet object address is :: " + this.hashCode());
		out.println("<br/>Current Request-Thread object address is :: " +Thread.currentThread().hashCode());
		out.close();
		
	}

}
