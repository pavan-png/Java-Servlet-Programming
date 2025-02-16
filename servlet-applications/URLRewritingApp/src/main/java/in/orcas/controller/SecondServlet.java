package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");
		
		HttpSession session = request.getSession();
		session.setAttribute("accType", accType);
		session.setAttribute("accBranch", accBranch);
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<form method='get' action ='" +response.encodeURL("./test3") + "'>");
		out.println("<table>");
		out.println("<tr><th>DepositorName</th><td><input type='text' name ='depName'/></td></tr>");
		out.println("<tr><th>DepositAmount</th><td><input type='text' name ='depAmount'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='Next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.close();
		
	}

}
