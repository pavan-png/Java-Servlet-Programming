package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String mobile = request.getParameter("mobile");
		
		HttpSession session = request.getSession();
		session.setAttribute("mail", mail);
		session.setAttribute("mobile", mobile);
		
		Object name = session.getAttribute("name");
		Object age = session.getAttribute("age");
		Object qual = session.getAttribute("qual");
		Object design = session.getAttribute("design");
		Object uemail = session.getAttribute("mail");
		Object umobile = session.getAttribute("mobile");
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		out.println("<center>");
		out.println("<table border='1' bgcolor='yellow'>");
		out.println("<tr><td>NAME</td><td>" + name + "</td></tr>");
		out.println("<tr><td>AGE</td><td>" + age + "</td></tr>");
		out.println("<tr><td>QUAL</td><td>" + qual + "</td></tr>");
		out.println("<tr><td>DESIGN</td><td>" + design + "</td></tr>");
		out.println("<tr><td>GMAIL</td><td>" + uemail + "</td></tr>");
		out.println("<tr><td>MOBILE</td><td>" + umobile + "</td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.close();

	
	}

}
