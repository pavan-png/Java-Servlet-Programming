package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String saddr = request.getParameter("saddr");
		
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center>");
		out.println("<form action ='./test2'>");
		out.println("<table>");
		out.println("<input type='hidden' name = 'sid' value='"+sid+"'/>");
		out.println("<input type='hidden' name = 'sname' value='"+sname+"'/>");
		out.println("<input type='hidden' name = 'saddr' value='"+saddr+"'/>");
		out.println("<tr><th>SAGE</th><td><input type='text' name ='sage'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.close();
	}

}
