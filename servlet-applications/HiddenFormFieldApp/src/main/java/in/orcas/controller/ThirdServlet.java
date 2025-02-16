package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		String sage = request.getParameter("sage");
		String semail = request.getParameter("semail");
		
	
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='orange'>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>SID</th><td>" + sid + "</td></tr>");
		out.println("<tr><th>SNAME</th><td>" + sname + "</td></tr>");
		out.println("<tr><th>SADDR</th><td>" + saddr + "</td></tr>");
		out.println("<tr><th>SAGE</th><td>" + sage + "</td></tr>");
		out.println("<tr><th>SEMAIL</th><td>" + semail + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.close();
		
	}

}
