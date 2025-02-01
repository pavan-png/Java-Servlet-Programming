package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntillizationParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center><h1>Initialziation Paramters</h1></center><hr/>");
		out.println("<table border='1'>");
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");
		Enumeration<String> parameterNames = getInitParameterNames();
		while(parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			String parameterValue = getInitParameter(parameterName);
			out.println("<tr><td>" + parameterName + "</td><td>" + parameterValue + "</td></tr>");
		}
		out.println("</table>");
		out.close();
		
		
	}

}
