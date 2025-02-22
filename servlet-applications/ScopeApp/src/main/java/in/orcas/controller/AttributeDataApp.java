package in.orcas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo")
public class AttributeDataApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		context.setAttribute("name", "nitin");
		context.setAttribute("address", "bengaluru");
		out.println("<html><head><title>Attribute Data</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:blue;'>Dynamic information in ApplicationScope ...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>AttributeName</th><th>AttributeValue</th></tr>");
		context.setAttribute("userName","pavan" );
		context.setAttribute("address","vijayawada");
		Enumeration<String> attributeNames = context.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			// value should be stored in object only. otherwise classcast exception
			Object attributeValue =   context.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>" + attributeName + "</td>"); 
			out.println("<td>" + attributeValue + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
