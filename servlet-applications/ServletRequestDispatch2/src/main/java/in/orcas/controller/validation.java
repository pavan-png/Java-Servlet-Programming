package in.orcas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valid")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		if(userName.equalsIgnoreCase("pavan")&& password.equalsIgnoreCase("1234")) {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/home");
			reqDisp.forward(request, response);
		}
		else {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/error");
			reqDisp.forward(request, response);
		}
	}

	
	

}
