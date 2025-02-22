package in.orcas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		Cookie c1 = new Cookie("pid",pid);
		Cookie c2 = new Cookie("pname",pname);
	//	product name should not be given with spaces
		response.addCookie(c1);
		response.addCookie(c2);
		RequestDispatcher reqDis = request.getRequestDispatcher("/form2.html");
		reqDis.forward(request,response);
	}

}
