package in.orcas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qual = request.getParameter("qual");
		String design = request.getParameter("design");
		
		HttpSession session = request.getSession();
		session.setAttribute("qual", qual);
		session.setAttribute("design", design);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("/form3.html");
		reqDis.forward(request, response);
	}

}
