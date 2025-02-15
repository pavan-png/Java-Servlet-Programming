package in.orcas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcost = request.getParameter("pcost");
		String pquantity = request.getParameter("pquantity");
		Cookie c3 = new Cookie("pcost", pcost);
		Cookie c4 = new Cookie("pquantity",pquantity);
		response.addCookie(c3);
		response.addCookie(c4);
		RequestDispatcher reqDis = request.getRequestDispatcher("/form3.html");
		reqDis.forward(request, response);
	}

}
